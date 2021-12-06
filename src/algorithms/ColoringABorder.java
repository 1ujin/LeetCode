package algorithms;

import java.util.Arrays;

public class ColoringABorder {

    private int m, n, color, src;
    private int[][] grid;
    private boolean[][] visited;

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        m = grid.length;
        n = grid[0].length;
        this.color = color;
        this.grid = grid;
        visited = new boolean[m][n];
        src = grid[row][col];
        dfs(row, col);
        return grid;
    }

    private boolean dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= m || col >= n)
            return false;
        if (visited[row][col])
            return true;
        if (grid[row][col] != src)
            return false;
        visited[row][col] = true;
        if (!dfs(row - 1, col)
                | !dfs(row, col - 1)
                | !dfs(row + 1, col)
                | !dfs(row, col + 1))
            grid[row][col] = color;
        return true;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
        System.out.println(Arrays.deepToString(
                new ColoringABorder().colorBorder(grid, 1, 1, 2)));
    }

}
