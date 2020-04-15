package lcof;

public class Solution16 {
    
    public double myPow(double x, int n) {
        return myPow(x, (long) n);
    }

    private double myPow(double x, long n) {
        if (n == 0)
            return 1.0;
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        double half = myPow(x, n / 2);
        if (n % 2 == 0)
            return half * half;
        else
            return half * half * x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution16().myPow(2.10000, 3));
    }

}
