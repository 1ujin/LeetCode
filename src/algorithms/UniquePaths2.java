package algorithms;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int h = obstacleGrid.length, w = obstacleGrid[0].length;
        int[] dp = new int[w];
        dp[0] = 1 - obstacleGrid[0][0];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (obstacleGrid[i][j] == 1)
                    dp[j] = 0;
                else if (j >= 1 && obstacleGrid[i][j - 1] == 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[w - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        System.out.println(new UniquePaths2().uniquePathsWithObstacles(grid));
    }

}
