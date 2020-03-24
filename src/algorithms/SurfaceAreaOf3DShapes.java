package algorithms;

public class SurfaceAreaOf3DShapes {
    
    public int surfaceArea(int[][] grid) {
        int area = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int h = grid[i][j];
                area += (h > 0) ? (h << 2) + 2 : 0;
                area -= i > 0 ? Math.min(h, grid[i - 1][j]) << 1 : 0;
                area -= j > 0 ? Math.min(h, grid[i][j - 1]) << 1 : 0;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        System.out.println(new SurfaceAreaOf3DShapes().surfaceArea(new int[][] {
            {2, 2, 2}, {2, 1, 2}, {2, 2, 2}
        }));
    }

}
