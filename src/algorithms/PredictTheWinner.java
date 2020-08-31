package algorithms;

public class PredictTheWinner {

    public boolean predictTheWinner(int[] nums) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++)
            dp[i][i] = nums[i];
        for (int i = len - 2; i >= 0; i--)
            for (int j = i + 1; j < len; j++)
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
        return dp[0][len - 1] >= 0;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 5, 2, 4, 6 };
        System.out.println(new PredictTheWinner().predictTheWinner(nums));
    }

}
