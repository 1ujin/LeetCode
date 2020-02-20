package algorithms;

public class PowXN {
    
    // binary search
    public static double myPow(double x, int n) {
        long N = n;
        return myPow(x, N);
    }

    public static double myPow(double x, long n) {
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
        long startTime = System.nanoTime();
        double num = myPow(2.00000, -2);
        long endTime = System.nanoTime();
        System.out.println(num);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
