package algorithms;

import java.util.Arrays;

public class RunningSumOf1dArray {

    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(new RunningSumOf1dArray().runningSum(nums)));
    }

}
