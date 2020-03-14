package algorithms;

public class MaxAreaOfIsland {
    
    private int[][] grid;
    private int height;
    private int width;
    
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        height = grid.length;
        width = grid[0].length;
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (this.grid[i][j] == 1) {
                    int tmp = dfs(i, j, 0);
                    max = max > tmp ? max : tmp;
                }
            }
        }
        return max;
    }
    
    private int dfs(int x, int y, int area) {
        area++;
        grid[x][y] = 2;
        if (x > 0 && grid[x - 1][y] == 1) area = dfs(x - 1, y, area);
        if (y > 0 && grid[x][y - 1] == 1) area = dfs(x, y - 1, area);
        if (x + 1 < height && grid[x + 1][y] == 1) area = dfs(x + 1, y, area);
        if (y + 1 < width && grid[x][y + 1] == 1) area = dfs(x, y + 1, area);
        return area;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {0,0,1,0,0,0,0,1,0,0,0,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,1,1,0,1,0,0,0,0,0,0,0,0},
            {0,1,0,0,1,1,0,0,1,0,1,0,0},
            {0,1,0,0,1,1,0,0,1,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,0,1,1,1,0,0,0},
            {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        long startTime = System.nanoTime();
        int result = new MaxAreaOfIsland().maxAreaOfIsland(grid);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
