package algorithms;

import java.util.Arrays;
import java.util.Random;

public class RandomPointInNonOverlappingRectangles {

    private Random random;
    private int[][] rects;
    private int[] preSum;
    private int len;

    public RandomPointInNonOverlappingRectangles(int[][] rects) {
        random = new Random();
        this.rects = rects;
        len = rects.length;
        preSum = new int[len + 1];
        for (int i = 0; i < len; i++)
            preSum[i + 1] = preSum[i] + (rects[i][2] - rects[i][0] + 1)
                    * (rects[i][3] - rects[i][1] + 1);
    }

    public int[] pick() {
        int pointIdx = random.nextInt(preSum[len]);
        int rectIdx = binarySearch(pointIdx + 1) - 1;
        int[] rect = rects[rectIdx];
        pointIdx -= preSum[rectIdx];
        int a = rect[0], b = rect[1], y = rect[3];
        int col = y - b + 1;
        int w = pointIdx / col;
        int h = pointIdx - col * w;
        return new int[] { a + w, b + h };
    }

    private int binarySearch(int target) {
        int lo = 0, hi = len;
        while (lo <= hi) {
            int mid = lo + hi >> 1;
            if (preSum[mid] > target)
                hi = mid - 1;
            else if (preSum[mid] < target)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[][] rects = { { -2, -2, 1, 1 }, { 2, 2, 4, 6 } };
        RandomPointInNonOverlappingRectangles solution = new RandomPointInNonOverlappingRectangles(rects);
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
        System.out.println(Arrays.toString(solution.pick()));
    }

}
