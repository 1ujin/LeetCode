package algorithms;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int s, int[] nums) {
        int lo = 0, hi = 0, sum = 0, min = Integer.MAX_VALUE;
        while (hi < nums.length) {
            sum += nums[hi++];
            while (sum >= s) {
                min = Math.min(min, hi - lo);
                sum -= nums[lo++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, nums));
    }

}
