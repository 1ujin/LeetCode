package algorithms;

public class NumberOfIslands {
    
    private char[][] grid;
    private int h, w, count = 0;
    
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.h = grid.length;
        if (this.h == 0) return 0;
        this.w = grid[0].length;
        if (this.w == 0) return 0;
        for (int i = 0; i < h; i++)
            for (int j = 0; j < w; j++)
                if (grid[i][j] == '1') {
                    count++;
                    dfs(i, j);
                }
        return count;
    }

    private void dfs(int i, int j) {
        if (i < 0 || i >= h || j < 0 || j >= w || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(i - 1, j);
        dfs(i + 1, j);
        dfs(i, j - 1);
        dfs(i, j + 1);
    }

    public static void main(String[] args) {
        char[][] grid = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' } };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

}
