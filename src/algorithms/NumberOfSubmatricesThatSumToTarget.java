package algorithms;

public class NumberOfSubmatricesThatSumToTarget {

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int count = 0, m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                dp[i][j] = matrix[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
        for (int i1 = 0; i1 < m; i1++)
            for (int j1 = 0; j1 < n; j1++)
                for (int i2 = i1 + 1; i2 <= m; i2++)
                    for (int j2 = j1 + 1; j2 <= n; j2++)
                        if (dp[i2][j2] + dp[i1][j1] - dp[i2][j1] - dp[i1][j2] == target)
                            count++;
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };
        System.out.println(new NumberOfSubmatricesThatSumToTarget().numSubmatrixSumTarget(matrix, 0));
    }

}
