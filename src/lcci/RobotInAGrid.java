package lcci;

import java.util.ArrayList;
import java.util.List;

public class RobotInAGrid {
    
    private int[][] grid;
    private int height;
    private int width;
    
    public List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
        this.grid = obstacleGrid;
        this.height = obstacleGrid.length;
        this.width = obstacleGrid[0].length;
        return dfs(0, 0, new ArrayList<>());
    }
    
    private List<List<Integer>> dfs(int i, int j, List<List<Integer>> list) {
        if (grid[i][j] == 1) return new ArrayList<>();
        List<List<Integer>> path = new ArrayList<>(list);
        List<Integer> pos = new ArrayList<>();
        pos.add(i);
        pos.add(j);
        path.add(pos);
        grid[i][j] = 2;
        if (i == height - 1 && j == width - 1) return path;
        if (i < height && j + 1 < width && grid[i][j + 1] == 0) {
            List<List<Integer>> ret = dfs(i, j + 1, path);
            if (ret.size() != 0) return ret;
        }
        if (i + 1 < height && j < width && grid[i + 1][j] == 0) {
            List<List<Integer>> ret = dfs(i + 1, j, path);
            if (ret.size() != 0) return ret;
        }
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] {
            {0, 0, 0, 0, 0},
            {0, 0, 0, 0, 1},
            {0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0},
        };
        long startTime = System.nanoTime();
        List<List<Integer>> result = new RobotInAGrid().pathWithObstacles(grid);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
