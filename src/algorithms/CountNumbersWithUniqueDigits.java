package algorithms;

public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int count = 10;
        for (int i = 0, tmp = 9; i < n - 1; i++) {
            tmp *= 9 - i;
            count += tmp;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CountNumbersWithUniqueDigits()
                .countNumbersWithUniqueDigits(8));
    }

}
