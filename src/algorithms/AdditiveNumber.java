package algorithms;

public class AdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        if (len < 3)
            return false;
        char[] cs = num.toCharArray();
        for (int i = 1; i <= (len - 1) / 2; i++) {
            if (i > 1 && cs[0] == '0')
                break;
            for (int j = i + 1; len - j >= i && len - j >= j - i; j++) {
                if (j - i > 1 && cs[i] == '0')
                    break;
                String num1 = num.substring(0, i);
                String num2 = num.substring(i, j);
                String remain = num.substring(j);
                if (isAdditive(num1, num2, remain))
                    return true;
            }
        }
        return false;
    }

    private boolean isAdditive(String num1, String num2, String remain) {
        if (remain.equals(""))
            return true;
        long sum = Long.parseLong(num1) + Long.parseLong(num2);
        String num3 = String.valueOf(sum);
        if (!remain.startsWith(num3))
            return false;
        return isAdditive(num2, num3, remain.substring(num3.length()));
    }

    public static void main(String[] args) {
        System.out.println(new AdditiveNumber().isAdditiveNumber("198019823962"));
    }

}
