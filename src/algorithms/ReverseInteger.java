package algorithms;

public class ReverseInteger {
    
    public static int reverse(int x) {
        int ret = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            ret = ret * 10 + pop;
        }
        return ret;
    }

    public static void main(String[] args) {
        for (int i = 0; i < Integer.numberOfLeadingZeros(Integer.MAX_VALUE); i++) System.out.print(0);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        for (int i = 0; i < Integer.numberOfLeadingZeros(0); i++) System.out.print(0);
        System.out.println();
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        long startTime = System.nanoTime();
        reverse(1234);
        long endTime = System.nanoTime();
        System.out.println("Duration: " + (endTime - startTime) + "ns");
    }

}
