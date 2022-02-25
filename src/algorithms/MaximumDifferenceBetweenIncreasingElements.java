package algorithms;

public class MaximumDifferenceBetweenIncreasingElements {

    public int maximumDifference(int[] nums) {
        int diff = -1;
        for (int i = 1, min = nums[0]; i < nums.length; i++) {
            if (nums[i] > min)
                diff = Math.max(diff, nums[i] - min);
            else
                min = Math.min(min, nums[i]);
        }
        return diff;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 4, 3, 2 };
        System.out.println(new MaximumDifferenceBetweenIncreasingElements()
                .maximumDifference(nums));
    }

}
