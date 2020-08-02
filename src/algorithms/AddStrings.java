package algorithms;

public class AddStrings {
    
    public String addStrings(String num1, String num2) {
        char[] cs1 = num1.toCharArray(), cs2 = num2.toCharArray();
        int carry = 0, len1 = cs1.length, len2 = cs2.length;
        StringBuilder sb = new StringBuilder();
        while (len1 > 0 || len2 > 0 || carry != 0) {
            int c = (--len1 < 0 ? 0 : cs1[len1] - '0')
                    + (--len2 < 0 ? 0 : cs2[len2] - '0') + carry;
            carry = c > 9 ? 1 : 0;
            c -= carry * 10;
            sb.append(c);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("12345", "67890"));
    }

}
