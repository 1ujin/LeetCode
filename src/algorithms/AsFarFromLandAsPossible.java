package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    
    public int maxDistance(int[][] grid) {
        int N = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                if (grid[i][j] == 1)
                    queue.offer(new int[] {i, j, 0});
        int[] t = new int[] {0, 0, -1};
        while (!queue.isEmpty()) {
            t = queue.poll();
            int i = t[0], j = t[1], k = t[2];
            if (i > 0 && grid[i - 1][j] == 0) {
                queue.offer(new int[] {i - 1, j, k + 1});
                grid[i - 1][j] = 1;
            }
            if (i + 1 < N && grid[i + 1][j] == 0) {
                queue.offer(new int[] {i + 1, j, k + 1});
                grid[i + 1][j] = 1;
            }
            if (j > 0 && grid[i][j - 1] == 0) {
                queue.offer(new int[] {i, j - 1, k + 1});
                grid[i][j - 1] = 1;
            }
            if (j + 1 < N && grid[i][j + 1] == 0) {
                queue.offer(new int[] {i, j + 1, k + 1});
                grid[i][j + 1] = 1;
            }
        }
        return t[2] == 0 ? -1 : t[2];
    }
    
    public static void main(String[] args) {
        System.out.println(new AsFarFromLandAsPossible().
                maxDistance(new int[][] {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}}));
    }

}
