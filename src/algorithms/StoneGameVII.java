package algorithms;

public class StoneGameVII {

    public int stoneGameVII(int[] stones) {
        int len = stones.length;
        int[][] dp = new int[len][len], sum = new int[len][len];
        for (int i = 2; i <= len; i++) {
            for (int j = 0; j <= len - i; j++) {
                if (i == 2) {
                    dp[j][i + j - 1] = Math.max(stones[j], stones[i + j - 1]);
                    sum[j][i + j - 1] = stones[j] + stones[i + j - 1];
                } else {
                    dp[j][i + j - 1] = Math.max(
                            sum[j][i + j - 2] - dp[j][i + j - 2],
                            sum[j + 1][i + j - 1] - dp[j + 1][i + j - 1]);
                    sum[j][i + j - 1] = stones[j] + sum[j + 1][i + j - 1];
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        int[] stones = { 5, 3, 1, 4, 2 };
        System.out.println(new StoneGameVII().stoneGameVII(stones));
    }

}
