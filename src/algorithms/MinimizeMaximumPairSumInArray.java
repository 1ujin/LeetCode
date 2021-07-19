package algorithms;

import java.util.Arrays;

public class MinimizeMaximumPairSumInArray {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length, max = 0;
        for (int i = 0; i < len >> 1; i++)
            max = Math.max(max, nums[i] + nums[len - 1 - i]);
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 5, 4, 2, 4, 6 };
        System.out.println(new MinimizeMaximumPairSumInArray().minPairSum(nums));
    }

}
