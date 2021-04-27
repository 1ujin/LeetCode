package algorithms;

public class SumOfSquareNumbers {
    
    // method 1 two-pointer
    public boolean judgeSquareSum1(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int d = a * a + b * b;
            if (c > d)
                a++;
            else if (c < d)
                b--;
            else return true;
        }
        return false;
    }
    
    // method 2 Fermat's theorem on sums of two squares
    public boolean judgeSquareSum2(int c) {
        for (int base = 0; base * base <= c; base++) {
            if (c % base != 0)
                continue;
            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }
            if (base % 4 == 3 && exp % 2 != 0)
                return false;
        }
        return c % 4 != 3;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum1(5));
    }

}
