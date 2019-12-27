package algorithms;

public class DivideTwoInteger {
    
    public static int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        boolean positive = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) positive = false;
        if (dividend < 0) dividend = -dividend;
        if (divisor < 0) divisor = -divisor;
        int tmp = divisor, n = 0, quotient = 0;
        StringBuffer sb = new StringBuffer();
        while (dividend >= tmp) {
            n++;
            tmp <<= 1;
        }
        tmp = tmp >> 1;
        for (int i = 0; i < n; i++) {
            if (dividend >= tmp) {
                sb.append(1);
                quotient <<= 1;
                if (quotient >= Integer.MAX_VALUE - 1) return Integer.MAX_VALUE;
                quotient += 1;
                dividend -= tmp;
            }
            else {
                sb.append(0);
                quotient <<= 1;
            }
            tmp >>= 1;
        }
        System.out.println(sb.toString());
        System.out.println(quotient);
        return positive ? quotient : -quotient;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int quotient = divide(-2147483648, -1);
        long endTime = System.nanoTime();
        System.out.println(quotient);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
