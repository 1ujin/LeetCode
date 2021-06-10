package algorithms;

public class PerfectSquares {
    
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = -1 >>> 1;
            for (int j = 1; j * j <= i; j++)
                min = Math.min(min, dp[i - j * j]);
            dp[i] = min + 1;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new PerfectSquares().numSquares(12));
    }

}
