package algorithms;

public class MultiplyStrings {
    
    // method 1
    public static String multiply1(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        StringBuilder tmp1 = new StringBuilder(""), tmp2 = new StringBuilder("");
        for (int i = num1.length() - 1; i >= 0; i--) {
            int num = 0, carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                num = ((int) num1.charAt(i) - 48) * ((int) num2.charAt(j) - 48) + carry;
                tmp1.insert(0, (char) (num % 10 + 48));
                carry = num / 10;
                num %= 10;
            }
            if (carry != 0) tmp1.insert(0, (char) (carry + 48));
            if (i >= num1.length() - 1) {
                tmp2 = tmp1;
                tmp1 = new StringBuilder("");
                continue;
            }
            int tmpCarry = 0;
            int k;
            int overlap = tmp2.length() - (num1.length() - 1 - i);
            for (k = tmp1.length() - 1; k >= tmp1.length() - overlap; k--) {
                num = ((int) tmp2.charAt(k - tmp1.length() + overlap) - 48) + ((int) tmp1.charAt(k) - 48) + tmpCarry;
                tmp2.setCharAt(k - tmp1.length() + overlap, (char) (num % 10 + 48));
                tmpCarry = num / 10;
            }
            while (tmpCarry != 0 || k >= 0) {
                if (k < 0) {
                    num = tmpCarry;
                } else {
                    num = (int) tmp1.charAt(k) - 48 + tmpCarry;
                }
                tmpCarry = num / 10;
                tmp2.insert(0, (char) (num % 10 + 48));
                k--;
            }
            tmp1 = new StringBuilder("");
        }
        return tmp2.toString();
    }
    
    // method 2 fastest
    public static String multiply2(String num1, String num2) {
        int carry = 0;
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                pos[i + j + 1] += (cs1[i] - '0') * (cs2[j] - '0');
            }
        }
        for (int i = m + n - 1; i >= 0; i--) {
            pos[i] += carry;
            carry = pos[i] / 10;
            pos[i] = pos[i] % 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (sb.length() == 0 && p == 0) {
                continue;
            }
            sb.append(p);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String result = multiply2("123", "456");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
