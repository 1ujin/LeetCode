package algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix {

    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length, n = mat[0].length;
        int[][] counts = new int[m][2];
        for (int i = 0; i < m; i++) {
            counts[i][0] = i;
            for (int j = 0; j < n && mat[i][j] == 1; j++)
                counts[i][1]++;
        }
        PriorityQueue<int[]> queue = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] count : counts)
            queue.offer(count);
        int[] weak = new int[k];
        for (int i = 0; i < k; i++)
            weak[i] = queue.poll()[0];
        return weak;
    }

    public static void main(String[] args) {
        int[][] mat = { { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 0 }, { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0 }, { 1, 1, 1, 1, 1 } };
        System.out.println(Arrays.toString(new TheKWeakestRowsInAMatrix().kWeakestRows(mat, 3)));
    }

}
