package algorithms;

import java.util.Arrays;

public class MinimumNumberOfArrowsToBurstBalloons {
    
    public int findMinArrowShots(int[][] points) {
        int len = points.length;
        if (len < 2) return len;
        Arrays.sort(points, (a, b) -> a[1] <= b[1] ? -1 : 1);
        int count = 1, minRight = points[0][1];
        for (int i = 1; i < len; i++) {
            if (points[i][0] > minRight) {
                count++;
                minRight = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] points = { { 10, 16 }, { 2, 8 }, { 1, 6 }, { 7, 12 } };
        System.out.println(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points));
    }

}
