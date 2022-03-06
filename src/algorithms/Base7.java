package algorithms;

public class Base7 {

    public String convertToBase7(int num) {
        if (num == 0)
            return "0";
        boolean negative = num < 0;
        num = Math.abs(num);
        StringBuilder digits = new StringBuilder();
        while (num > 0) {
            digits.append(num % 7);
            num /= 7;
        }
        if (negative)
            digits.append('-');
        return digits.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(-202));
    }

}
