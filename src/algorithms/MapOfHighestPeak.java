package algorithms;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MapOfHighestPeak {

    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        int[][] matrix = new int[m][n];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    matrix[i][j] = 0;
                    queue.offer(new int[] { i, j });
                } else
                    matrix[i][j] = -1;
            }
        }
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int x = position[0], y = position[1], h = matrix[x][y] + 1;
            if (x - 1 >= 0 && matrix[x - 1][y] == -1) {
                matrix[x - 1][y] = h;
                queue.offer(new int[] { x - 1, y });
            }
            if (x + 1 < m && matrix[x + 1][y] == -1) {
                matrix[x + 1][y] = h;
                queue.offer(new int[] { x + 1, y });
            }
            if (y - 1 >= 0 && matrix[x][y - 1] == -1) {
                matrix[x][y - 1] = h;
                queue.offer(new int[] { x, y - 1 });
            }
            if (y + 1 < n && matrix[x][y + 1] == -1) {
                matrix[x][y + 1] = h;
                queue.offer(new int[] { x, y + 1 });
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int[][] isWater = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        System.out.println(Arrays.deepToString(new MapOfHighestPeak()
                .highestPeak(isWater)));
    }

}
