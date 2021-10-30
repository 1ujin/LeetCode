package algorithms;

import java.util.Arrays;

public class SingleNumber3 {

    public int[] singleNumber(int[] nums) {
        int xorsum = 0;
        for (int num : nums)
            xorsum ^= num;
        int singleXor = xorsum == Integer.MIN_VALUE ? xorsum : xorsum & -xorsum;
        int xorsum1 = 0, xorsum2 = 0;
        for (int num : nums) {
            if ((num & singleXor) != 0)
                xorsum1 ^= num;
            else
                xorsum2 ^= num;
        }
        return new int[] { xorsum1, xorsum2 };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 3, 2, 5 };
        System.out.println(Arrays.toString(new SingleNumber3().singleNumber(nums)));
    }

}
