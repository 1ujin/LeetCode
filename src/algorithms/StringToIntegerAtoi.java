package algorithms;

public class StringToIntegerAtoi {
    
    public static int myAtoi(String str) {
        if (str == null || str.length() == 0) return 0;
        int ret = 0, sign = 1;
        str = str.trim();
        int len = str.length();
        if (len == 0) return 0;
        int i = 0;
        char c = str.charAt(i);
        if (c == '+' || c == '-') {
            sign = c == '-' ? -1 : 1;
            i++;
        }
        for (; i < len; i++) {
            c = str.charAt(i);
            if (c < '0' || c > '9') break;
            if (ret * sign > Integer.MAX_VALUE / 10 || (ret * sign == Integer.MAX_VALUE / 10 && c > '7'))
                return Integer.MAX_VALUE;
            if (ret * sign < Integer.MIN_VALUE / 10 || (ret * sign == Integer.MIN_VALUE / 10 && c > '8'))
                return Integer.MIN_VALUE;
            ret = ret * 10 + (c - '0');
        }
        return ret * sign;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        myAtoi("-2147483648");
        long endTime = System.nanoTime();
        System.out.println("Duration: " + (endTime - startTime) + "ns");
        
    }

}
