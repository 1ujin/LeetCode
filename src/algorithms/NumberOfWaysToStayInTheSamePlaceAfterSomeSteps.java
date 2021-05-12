package algorithms;

public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    public int numWays(int steps, int arrLen) {
        int len = Math.min(steps, arrLen);
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 0; i < steps; i++) {
            int[] next = new int[len];
            for (int j = 0; j <= i && j < len; j++) {
                if (j > 0)
                    next[j - 1] = (dp[j] + next[j - 1]) % 1000000007;
                next[j] = (next[j] + dp[j]) % 1000000007;
                if (j < len - 1)
                    next[j + 1] = (dp[j] + next[j + 1]) % 1000000007;
            }
            dp = next;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfWaysToStayInTheSamePlaceAfterSomeSteps()
                .numWays(430, 148488));
    }

}
