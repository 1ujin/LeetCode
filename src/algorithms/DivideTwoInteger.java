package algorithms;

public class DivideTwoInteger {
    
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean positive = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) positive = false;
        if (dividend > 0) dividend = -dividend;
        if (divisor > 0) divisor = -divisor;
        int quotient = 0, tmp = divisor;
        // 获取大于等于被除数的除数最小的二倍数tmp
        while (dividend <= tmp << 1 && tmp << 1 < 0) tmp <<= 1;
        while (tmp <= divisor && dividend <= 0) {
            if (quotient << 1 == Integer.MIN_VALUE && positive) return Integer.MAX_VALUE;
            quotient <<= 1;
            if (dividend <= tmp) {
                dividend -= tmp;
                quotient += 1;
            }
            if (tmp == tmp >> 1) break;
            tmp >>= 1;
        }
        return positive ? quotient : -quotient;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int quotient = divide(Integer.MIN_VALUE, -1);
        long endTime = System.nanoTime();
        System.out.println(quotient);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
