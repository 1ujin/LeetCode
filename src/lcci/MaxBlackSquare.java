package lcci;

import java.util.Arrays;

public class MaxBlackSquare {
    
    public int[] findSquare(int[][] matrix) {
        int n = matrix.length;
        if (n < 1) return new int[0];
        int[][][] dp = new int[n][n][2];
        if (matrix[n - 1][n - 1] == 0) {
            dp[n - 1][n - 1][0] = 1;
            dp[n - 1][n - 1][1] = 1;
        }
        if (n < 2)
            return matrix[0][0] == 1 ? new int[0] : new int[] {0, 0, 1};
        for (int r = n - 2; r > -1; r--) {
            int c = n - 1;
            if (matrix[r][c] == 0) {
                dp[r][c][0] = dp[r + 1][c][0] + 1;
                dp[r][c][1] = 1;
            }
        }
        for (int c = n - 2; c > -1; c--) {
            int r = n - 1;
            if (matrix[r][c] == 0) {
                dp[r][c][0] = 1;
                dp[r][c][1] = dp[r][c + 1][1] + 1;
            }
        }
        int[] square = new int[3];
        int max = 0;
        for (int r = n - 2; r > -1; r--) {
            for (int c = n - 2; c > -1; c--) {
                if (matrix[r][c] == 0) {
                    dp[r][c][0] = dp[r + 1][c][0] + 1;
                    dp[r][c][1] = dp[r][c + 1][1] + 1;
                }
                int t = 1;
                int j = dp[r][c][0] < dp[r][c][1] ? dp[r][c][0] : dp[r][c][1];
                for (int i = j - 1; i > 0; i--)
                    if (dp[r + i][c][1] > i && dp[r][c + i][0] > i) {
                        t = i + 1;
                        break;
                    }
                if (t >= max) {
                    max = t;
                    square[0] = r;
                    square[1] = c;
                    square[2] = max;
                }
            }
        }
        return square;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
        System.out.println(
                Arrays.toString(new MaxBlackSquare().findSquare(matrix)));
    }

}
