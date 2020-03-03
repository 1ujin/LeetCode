package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RottingOranges {
    
    public int orangesRotting(int[][] grid) {
        int time = 0, count = 0, preLen = 0;
        int H = grid.length, W = grid[0].length;
        List<Integer> hList = new ArrayList<>(), wList = new ArrayList<>();
        for (int h = 0; h < H; h++) {
            for (int w = 0; w < W; w++) {
                if (grid[h][w] > 0) count++;
                if (grid[h][w] == 1 && (h < 1 || grid[h - 1][w] < 1) && (h >= H - 1 || grid[h + 1][w] < 1) && (w < 1 || grid[h][w - 1] < 1) && (w >= W - 1 || grid[h][w + 1] < 1)) return -1;
                else if (grid[h][w] == 2) {
                    hList.add(h);
                    wList.add(w);
                }
            }
        }
        while (true) {
            preLen = hList.size();
            for (int i = 0; i < preLen; i++) {
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
            if (hList.size() > preLen) time++;
            else break;
        }
        return count == hList.size() ? time : -1;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new RottingOranges().orangesRotting(new int[][] {
            {2, 1, 1},
            {1, 1, 0},
            {0, 1, 1},
        });
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
