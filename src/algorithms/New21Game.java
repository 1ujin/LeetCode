package algorithms;

public class New21Game {
    
    public double new21Game(int N, int K, int W) {
        if (K == 0) return 1.0d;
        double[] dp = new double[K + W + 1];
        for (int i = K; i <= N && i < K + W; i++)
            dp[i] = 1.0d;
        dp[K - 1] = 1.0d * Math.min(N - K + 1, W) / W;
        for (int i = K - 2; i >= 0; i--)
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W;
        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(new New21Game().new21Game(10, 1, 10));
    }

}
