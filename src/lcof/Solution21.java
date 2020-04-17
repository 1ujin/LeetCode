package lcof;

import java.util.Arrays;

public class Solution21 {
    
    public int[] exchange(int[] nums) {
        int lo = 0, hi = nums.length - 1, t = 0;
        while (lo < hi) {
            while (lo < hi && (nums[lo] & 1) == 1) lo++;
            while (lo < hi && (nums[hi] & 1) == 0) hi--;
            t = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = t;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(new Solution21().exchange(nums)));
    }

}
