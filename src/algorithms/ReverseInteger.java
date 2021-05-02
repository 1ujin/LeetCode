package algorithms;

public class ReverseInteger {
    
    public static int reverse(int x) {
        int y = 0, max = Integer.MAX_VALUE / 10, min = Integer.MIN_VALUE / 10;
        do {
            int z = x % 10;
            if (y == max && z > 7 || y > max || y == min && z < -8 || y < min)
                return 0;
            y = y * 10 + z;
        } while ((x /= 10) != 0);
        return y;
    }

    public static void main(String[] args) {
        for (int i = 0; i < Integer.numberOfLeadingZeros(Integer.MAX_VALUE); i++) System.out.print(0);
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
        for (int i = 0; i < Integer.numberOfLeadingZeros(0); i++) System.out.print(0);
        System.out.println();
        System.out.println(Integer.toBinaryString(-1));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        long startTime = System.nanoTime();
        int result = reverse(1234);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.println("Duration: " + (endTime - startTime) + "ns");
    }

}
