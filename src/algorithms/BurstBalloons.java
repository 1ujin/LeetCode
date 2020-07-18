package algorithms;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int len = nums.length + 2;
        int[] coins = new int[len];
        coins[0] = 1;
        coins[len - 1] = 1;
        System.arraycopy(nums, 0, coins, 1, len - 2);
        int[][] dp = new int[len][len];
        for (int left = len - 2; left >= 0; left--) {
            for (int right = left + 1; right < len; right++) {
                int max = 0;
                for (int i = left + 1; i < right; i++)
                    max = Math.max(max, dp[left][i] + dp[i][right]
                            + coins[left] * coins[i] * coins[right]);
                dp[left][right] = max;
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 5, 8 };
        System.out.println(new BurstBalloons().maxCoins(nums));
    }

}
