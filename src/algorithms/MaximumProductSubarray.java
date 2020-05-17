package algorithms;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int max = nums[0], min = max, result = max;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i], tmp = max;
            max = Math.max(num, Math.max(tmp * num, min * num));
            min = Math.min(num, Math.min(min * num, tmp * num));
            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, -2, 4 };
        System.out.println(new MaximumProductSubarray().maxProduct(nums));
    }

}
