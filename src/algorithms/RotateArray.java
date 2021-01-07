package algorithms;

import java.util.Arrays;

public class RotateArray {

    // method 1
    public void rotate1(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        while (k-- > 0) {
            int last = nums[len - 1];
            for (int i = len - 1; i > 0; i--)
                nums[i] = nums[i - 1];
            nums[0] = last;
        }
    }

    // method 2 fastest
    public void rotate2(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        while (begin < end) {
            int tmp = nums[begin];
            nums[begin++] = nums[end];
            nums[end--] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        new RotateArray().rotate2(nums, 3);
        System.out.println(Arrays.toString(nums));
    }

}
