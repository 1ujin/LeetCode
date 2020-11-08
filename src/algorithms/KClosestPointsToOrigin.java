package algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class KClosestPointsToOrigin {
    
    // method 1 priority queue
    public int[][] kClosest1(int[][] points, int K) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] * a[0]
                + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);
        for (int[] point : points)
            queue.offer(point);
        int[][] kPoints = new int[K][2];
        for (int i = 0; i < K; i++)
            kPoints[i] = queue.poll();
        return kPoints;
    }
    
    // method 2 quick sort fastest
    public int[][] kClosest2(int[][] points, int K) {
        return quickSort(points, 0, points.length - 1, K);
    }

    private int[][] quickSort(int[][] points, int left, int right, int K) {
        if (points.length < 2 || left >= right) return points;
        int lo = left, hi = right, pivot = distance(points[left + right >> 1]);
        while (lo <= hi) {
            while (distance(points[lo]) < pivot) lo++;
            while (distance(points[hi]) > pivot) hi--;
            if (lo < hi) swap(points, lo++, hi--);
            else if (lo == hi) lo++;
        }
        if (hi >= K) quickSort(points, left, hi, K);
        else quickSort(points, lo, right, K);
        return Arrays.copyOf(points, K);
    }
    
    // method 3 maximum heap sort
    public int[][] kClosest3(int[][] points, int K) {
        int len = points.length;
        for (int i = len - 1 >>> 1; i > -1; i--)
            maxHeapify(points, i, len);
        for (int i = len - 1; i >= 0; i--) {
            swap(points, 0, i);
            maxHeapify(points, 0, i);
        }
        return Arrays.copyOf(points, K);
    }

    private void maxHeapify(int[][] points, int i, int len) {
        int l = (i << 1) + 1, r = l + 1;
        if (l >= len) return;
        int maxc = l;
        if (r < len && distance(points[l]) < distance(points[r]))
            maxc = r;
        if (distance(points[i]) < distance(points[maxc])) {
            swap(points, i, maxc);
            maxHeapify(points, maxc, len);
        }
    }

    // common method
    private void swap(int[][] points, int i, int j) {
        int[] t = points[i];
        points[i] = points[j];
        points[j] = t;
    }

    // common method
    private int distance(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }

    public static void main(String[] args) {
        int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
        System.out.println(Arrays.deepToString(new KClosestPointsToOrigin()
                .kClosest2(points, 2)));
    }

}
