package lcof;

import java.util.Arrays;

public class Solution56I {

    public int[] singleNumbers(int[] nums) {
        int xor = 0;
        for (int i : nums)
            xor ^= i;
        // 选取一个不同位
        int low = Integer.lowestOneBit(xor);
        int a = 0, b = 0;
        for (int i : nums)
            // 将所有在该位不同的数字，分别亦或给两个数
            if ((i & low) == 0)
                a ^= i;
            else
                b ^= i;
        return new int[] { a, b };
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 10, 4, 1, 4, 3, 3 };
        System.out.println(Arrays.toString(new Solution56I().singleNumbers(nums)));
    }

}
