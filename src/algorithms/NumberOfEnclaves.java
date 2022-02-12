package algorithms;

public class NumberOfEnclaves {

    private int m, n;
    private int[][] grid;

    public int numEnclaves(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int num = 0;
        for (int i = 0; i < m; i++) {
            dfs(i, 0);
            dfs(i, n - 1);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j);
            dfs(m - 1, j);
        }
        for (int i = 1; i < m - 1; i++)
            for (int j = 1; j < n - 1; j++)
                if (grid[i][j] == 1)
                    num++;
        return num;
    }

    private void dfs(int x, int y) {
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 0)
            return;
        grid[x][y] = 0;
        dfs(x - 1, y);
        dfs(x, y - 1);
        dfs(x + 1, y);
        dfs(x, y + 1);
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 0, 0, 0 },
                { 1, 0, 1, 0 },
                { 0, 1, 1, 0 },
                { 0, 0, 0, 0 } };
        System.out.println(new NumberOfEnclaves().numEnclaves(grid));
    }

}
