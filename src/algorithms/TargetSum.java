package algorithms;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums)
            sum += num;
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0)
            return 0;
        int neg = diff >> 1;
        int[] dp = new int[neg + 1];
        dp[0] = 1;
        for (int num : nums)
            for (int i = neg; i >= num; i--)
                dp[i] += dp[i - num];
        return dp[neg];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 1, 1 };
        System.out.println(new TargetSum().findTargetSumWays(nums, 3));
    }

}
