package algorithms;

import java.util.Arrays;

public class SetMismatch {

    // method 1
    public int[] findErrorNums1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] error = { 1, nums[len - 1] == len ? 1 : len };
        for (int i = 0; i < len - 1; i++) {
            if (nums[i] == nums[i + 1])
                error[0] = nums[i];
            else if (nums[i] + 1 != nums[i + 1])
                error[1] = nums[i] + 1;
        }
        return error;
    }

    // method 2 fastest
    public int[] findErrorNums2(int[] nums) {
        int len = nums.length;
        int[] counts = new int[len], error = new int[2];
        for (int num : nums)
            counts[num - 1]++;
        for (int i = 0; i < len; i++)
            if (counts[i] != 1)
                error[counts[i] >> 1 ^ 1] = i + 1;
        return error;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 4 };
        System.out.println(Arrays.toString(new SetMismatch().findErrorNums2(nums)));
    }

}
