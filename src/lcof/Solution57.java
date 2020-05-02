package lcof;

import java.util.Arrays;

public class Solution57 {

    public int[] twoSum(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum > target) hi--;
            else if (sum < target) lo++;
            else return new int[] { nums[lo], nums[hi] };
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 26, 30, 31, 47, 60 };
        System.out.println(Arrays.toString(new Solution57().twoSum(nums, 40)));
    }

}
