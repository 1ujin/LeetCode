package algorithms;

import java.util.Arrays;

public class CountingBits {
    
    public int[] countBits(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i++)
            // i 为奇数时 bits[i] = bits[i - 1] + 1
            // i 为偶数时 bits[i] = bits[i >> 1]
            bits[i] = bits[i >> 1] + (i & 1);
        return bits;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new CountingBits().countBits(5)));
    }

}
