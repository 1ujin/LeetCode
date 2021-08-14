package algorithms;

public class OutOfBoundaryPaths {

    private int[][][] dp;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (maxMove < 0 || maxMove <= startRow && maxMove <= startColumn
                && maxMove < m - startRow && maxMove < n - startColumn)
            return 0;
        if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n)
            return 1;
        if (dp == null)
            dp = new int[m][n][maxMove + 1];
        if (dp[startRow][startColumn][maxMove] != 0)
            return dp[startRow][startColumn][maxMove];
        int count = 0;
        count += findPaths(m, n, maxMove - 1, startRow - 1, startColumn);
        count %= 1000000007;
        count += findPaths(m, n, maxMove - 1, startRow + 1, startColumn);
        count %= 1000000007;
        count += findPaths(m, n, maxMove - 1, startRow, startColumn - 1);
        count %= 1000000007;
        count += findPaths(m, n, maxMove - 1, startRow, startColumn + 1);
        count %= 1000000007;
        dp[startRow][startColumn][maxMove] = count;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new OutOfBoundaryPaths().findPaths(2, 2, 2, 0, 0));
    }

}
