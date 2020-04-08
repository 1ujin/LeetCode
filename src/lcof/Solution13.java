package lcof;

public class Solution13 {
    
    public int movingCount(int m, int n, int k) {
        boolean[][] grid = new boolean[m][n];
        return dfs(grid, k, 0, 0, 0);
    }

    private int dfs(boolean[][] grid, int k, int i, int j, int count) {
        if (grid[i][j]) return count;
        int sum = 0, m = i, n = j;
        while (m != 0) {
            sum += m % 10;
            m /= 10;
        }
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        if (sum > k) return count;
        grid[i][j] = true;
        count++;
        if (i > 0) count = dfs(grid, k, i - 1, j, count);
        if (j > 0) count = dfs(grid, k, i, j - 1, count);
        if (i < grid.length - 1) count = dfs(grid, k, i + 1, j, count);
        if (j < grid[0].length - 1) count = dfs(grid, k, i, j + 1, count);
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Solution13().movingCount(1, 2, 1));
    }

}
