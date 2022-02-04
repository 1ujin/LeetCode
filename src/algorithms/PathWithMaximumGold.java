package algorithms;

public class PathWithMaximumGold {

    private int[][] grid;
    private int m, n, max;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] != 0)
                    dfs(i, j, 0);
        return max;
    }

    private void dfs(int i, int j, int sum) {
        sum += grid[i][j];
        max = Math.max(max, sum);
        int gold = grid[i][j];
        grid[i][j] = 0;
        if (i > 0 && grid[i - 1][j] != 0)
            dfs(i - 1, j, sum);
        if (j > 0 && grid[i][j - 1] != 0)
            dfs(i, j - 1, sum);
        if (i + 1 < m && grid[i + 1][j] != 0)
            dfs(i + 1, j, sum);
        if (j + 1 < n && grid[i][j + 1] != 0)
            dfs(i, j + 1, sum);
        grid[i][j] = gold;
    }

    public static void main(String[] args) {
        int[][] grid = { { 0, 6, 0 }, { 5, 8, 7 }, { 0, 9, 0 } };
        System.out.println(new PathWithMaximumGold().getMaximumGold(grid));
    }

}
