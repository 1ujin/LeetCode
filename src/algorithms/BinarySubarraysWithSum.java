package algorithms;

public class BinarySubarraysWithSum {

    public int numSubarraysWithSum(int[] nums, int goal) {
        int len = nums.length, count = 0;
        int[] dp = new int[len + 1], counts = new int[len + 1];
        for (int i = 0; i < len; i++)
            dp[i + 1] = nums[i] + dp[i];
        for (int sum : dp) {
            int diff = sum - goal;
            if (diff >= 0)
                count += counts[diff];
            counts[sum]++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 0, 1, 0, 1 };
        System.out.println(new BinarySubarraysWithSum().numSubarraysWithSum(nums, 2));
    }

}
