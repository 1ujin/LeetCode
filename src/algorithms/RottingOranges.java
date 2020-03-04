package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RottingOranges {
    
    // method 1 breadth-first search
    public int orangesRotting1(int[][] grid) {
        int time = 0, count = 0, currentLen = 0;
        int H = grid.length, W = grid[0].length;
        List<Integer> hList = new ArrayList<>(), wList = new ArrayList<>();
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if (grid[h][w] > 0) count++;
                if (grid[h][w] == 1 && (h < 1 || grid[h - 1][w] < 1) && (h >= H - 1 || grid[h + 1][w] < 1) && (w < 1 ||
                        grid[h][w - 1] < 1) && (w >= W - 1 || grid[h][w + 1] < 1)) return -1;
                else if (grid[h][w] == 2) {
                    hList.add(h);
                    wList.add(w);
                }
            }
        }
        while (true) {
            int preLen = currentLen;
            currentLen = hList.size();
            for (int i = preLen; i < currentLen; i++) {
                int w = wList.get(i), h = hList.get(i);
                if (h > 0 && grid[h - 1][w] == 1) {
                    grid[h - 1][w] = 2;
                    hList.add(h - 1);
                    wList.add(w);
                }
                if (h < H - 1 && grid[h + 1][w] == 1) {
                    grid[h + 1][w] = 2;
                    hList.add(h + 1);
                    wList.add(w);
                }
                if (w > 0 && grid[h][w - 1] == 1) {
                    grid[h][w - 1] = 2;
                    hList.add(h);
                    wList.add(w - 1);
                }
                if (w < W - 1 && grid[h][w + 1] == 1) {
                    grid[h][w + 1] = 2;
                    hList.add(h);
                    wList.add(w + 1);
                }
            }
            if (hList.size() > currentLen) time++;
            else break;
        }
        return count == hList.size() ? time : -1;
    }
    
    // method 2 depth-first search
    int H, W;
    
    public int orangesRotting2(int[][] grid) {
        H = grid.length;
        W = grid[0].length;
        int time = 0;
        boolean hasRotting = false;
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++)
                if (grid[i][j] == 2) {
                    hasRotting = true;
                    dfs(grid, i, j, 2);
                }
        for (int i = 0; i < H; i++)
            for (int j = 0; j < W; j++) {
                if (grid[i][j] == 1) return -1;
                time = time > grid[i][j] ? time : grid[i][j];
            }
        if (!hasRotting) return 0;
        // 减去代表腐烂的 2
        return time - 2;
    }
    
    private void dfs(int[][] grid, int x, int y, int val) {
        grid[x][y] = val;
        if (x > 0 && (grid[x - 1][y] == 1 || val + 1 < grid[x - 1][y])) dfs(grid, x - 1, y, val + 1);
        if (x < H - 1 && (grid[x + 1][y] == 1 || val + 1 < grid[x + 1][y])) dfs(grid, x + 1, y, val + 1);
        if (y > 0 && (grid[x][y - 1] == 1 || val + 1 < grid[x][y - 1])) dfs(grid, x, y - 1, val + 1);
        if (y < W - 1 && (grid[x][y + 1] == 1 || val + 1 < grid[x][y + 1])) dfs(grid, x, y + 1, val + 1);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new RottingOranges().orangesRotting2(new int[][] {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1},
        });
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
