package algorithms;

public class ProjectionAreaOf3dShapes {

    public int projectionArea(int[][] grid) {
        int a = 0, b = 0, c = 0, n = grid.length;
        for (int i = 0; i < n; i++) {
            int w = 0, h = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0)
                    a++;
                h = grid[i][j] > h ? grid[i][j] : h;
                w = grid[j][i] > w ? grid[j][i] : w;
            }
            b += h;
            c += w;
        }
        return a + b + c;
    }

    public static void main(String[] args) {
        int[][] grid = { { 1, 2 }, { 3, 4 } };
        System.out.println(new ProjectionAreaOf3dShapes().projectionArea(grid));
    }

}
