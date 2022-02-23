package algorithms;

import java.util.Arrays;

public class WhereWillTheBallFall {

    // method 1
    public int[] findBall1(int[][] grid) {
        int len = grid[0].length;
        int[] balls = new int[len];
        for (int i = 0; i < len; i++) {
            balls[i] = i;
            for (int[] row : grid) {
                if (balls[i] < 0)
                    break;
                else if (balls[i] < len - 1 && row[balls[i]] == 1
                        && row[balls[i]] == row[balls[i] + 1])
                    balls[i]++;
                else if (balls[i] > 0 && row[balls[i]] == -1
                        && row[balls[i]] == row[balls[i] - 1])
                    balls[i]--;
                else
                    balls[i] = -1;
            }
        }
        return balls;
    }

    // method 2 fastest depth-first search
    public int[] findBall2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] balls = new int[n];
        for (int i = 0; i < n; i++)
            balls[i] = dfs(grid, m, n, 0, i);
        return balls;
    }

    private int dfs(int[][] grid, int m, int n, int row, int col) {
        if (row == m)
            return col;
        if (col == 0 && grid[row][col] == -1)
            return -1;
        if (col == n - 1 && grid[row][col] == 1)
            return -1;
        if (grid[row][col] == 1 && grid[row][col + 1] == -1)
            return -1;
        if (grid[row][col] == -1 && grid[row][col - 1] == 1)
            return -1;
        return dfs(grid, m, n, row + 1, col + grid[row][col]);
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 1, 1, 1, 1, 1 }, { -1, -1, -1, -1, -1, -1 },
                { 1, 1, 1, 1, 1, 1 }, { -1, -1, -1, -1, -1, -1 } };
        System.out.println(Arrays.toString(new WhereWillTheBallFall().findBall2(grid)));
    }

}
