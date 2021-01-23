package algorithms;

public class LongestContinuousIncreasingSubsequence {

    public int findLengthOfLCIS(int[] nums) {
        if (nums.length < 2)
            return nums.length;
        int max = 0, current = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1])
                current++;
            else {
                max = Math.max(max, current);
                current = 1;
            }
        }
        return Math.max(max, current);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(new LongestContinuousIncreasingSubsequence().findLengthOfLCIS(nums));
    }

}
