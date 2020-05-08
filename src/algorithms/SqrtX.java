package algorithms;

public class SqrtX {
    
    public int mySqrt(int x) {
        if (x < 2) return x;
        long lo = 0, hi = x;
        while (lo < hi - 1) {
            long mid = lo + hi >>> 1, prod = mid * mid;
            if (prod > x)
                hi = mid;
            else lo = mid;
        }
        return (int) lo;
    }

    public static void main(String[] args) {
        System.out.println(new SqrtX().mySqrt(2147395600));
    }

}
