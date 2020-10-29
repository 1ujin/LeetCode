package algorithms;

public class IslandPerimeter {
    
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0, h = grid.length, w = grid[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 0) continue;
                if (i == 0 || grid[i - 1][j] == 0) perimeter += 2;
                if (j == 0 || grid[i][j - 1] == 0) perimeter += 2;
            }
        }
        return perimeter;
    }

    public static void main(String[] args) {
        int[][] grid = {
                { 0, 1, 0, 0 },
                { 1, 1, 1, 0 },
                { 0, 1, 0, 0 },
                { 1, 1, 0, 0 } };
        System.out.println(new IslandPerimeter().islandPerimeter(grid));
    }

}
