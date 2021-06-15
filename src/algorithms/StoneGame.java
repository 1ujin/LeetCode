package algorithms;

public class StoneGame {

    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++)
            dp[i] = piles[i];
        for (int i = len - 2; i >= 0; i--)
            for (int j = i + 1; j < len; j++)
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
        return dp[len - 1] > 0;
    }

    public static void main(String[] args) {
        int[] piles = { 5, 3, 4, 5 };
        System.out.println(new StoneGame().stoneGame(piles));
    }

}
