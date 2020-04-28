package lcof;

public class Solution47 {

    public int maxValue(int[][] grid) {
        int h = grid.length, w = grid[0].length;
        for (int i = 1; i < w; i++)
            grid[0][i] += grid[0][i - 1];
        for (int i = 1; i < h; i++)
            grid[i][0] += grid[i - 1][0];
        for (int i = 1; i < h; i++)
            for (int j = 1; j < w; j++)
                grid[i][j] += Math.max(grid[i - 1][j], grid[i][j - 1]);
        return grid[h - 1][w - 1];
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
        System.out.println(new Solution47().maxValue(grid));
    }

}
