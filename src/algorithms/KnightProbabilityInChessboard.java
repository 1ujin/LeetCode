package algorithms;

import java.util.Arrays;

public class KnightProbabilityInChessboard {

    public double knightProbability(int n, int k, int row, int column) {
        double[][][] dp = new double[k + 1][n][n];
        for (int i = 0; i < n; i++)
            Arrays.fill(dp[0][i], 1);
        for (int step = 1; step <= k; step++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i - 1 >= 0 && j - 2 >= 0)
                        dp[step][i][j] += dp[step - 1][i - 1][j - 2] / 8;
                    if (i - 2 >= 0 && j - 1 >= 0)
                        dp[step][i][j] += dp[step - 1][i - 2][j - 1] / 8;
                    if (i + 1 < n && j - 2 >= 0)
                        dp[step][i][j] += dp[step - 1][i + 1][j - 2] / 8;
                    if (i + 2 < n && j - 1 >= 0)
                        dp[step][i][j] += dp[step - 1][i + 2][j - 1] / 8;
                    if (i - 1 >= 0 && j + 2 < n)
                        dp[step][i][j] += dp[step - 1][i - 1][j + 2] / 8;
                    if (i - 2 >= 0 && j + 1 < n)
                        dp[step][i][j] += dp[step - 1][i - 2][j + 1] / 8;
                    if (i + 2 < n && j + 1 < n)
                        dp[step][i][j] += dp[step - 1][i + 2][j + 1] / 8;
                    if (i + 1 < n && j + 2 < n)
                        dp[step][i][j] += dp[step - 1][i + 1][j + 2] / 8;
                }
            }
        }
        return dp[k][row][column];
    }

    public static void main(String[] args) {
        System.out.println(new KnightProbabilityInChessboard()
                .knightProbability(3, 2, 0, 0));
    }

}
