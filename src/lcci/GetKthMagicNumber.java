package lcci;

public class GetKthMagicNumber {

    public int getKthMagicNumber(int k) {
        int[] dp = new int[k];
        dp[0] = 1;
        int p3 = 0, p5 = 0, p7 = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.min(dp[p3] * 3, Math.min(dp[p5] * 5, dp[p7] * 7));
            if (dp[i] == dp[p3] * 3) p3++;
            if (dp[i] == dp[p5] * 5) p5++;
            if (dp[i] == dp[p7] * 7) p7++;
        }
        return dp[k - 1];
    }

    public static void main(String[] args) {
        System.out.println(new GetKthMagicNumber().getKthMagicNumber(251));
    }

}
