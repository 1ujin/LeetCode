package algorithms;

import java.util.Arrays;

public class NonOverlappingIntervals {
    
    // method 1 dynamic programming
    public int eraseOverlapIntervals1(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return 0;
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++)
                if (intervals[j][1] <= intervals[i][0])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            max = Math.max(max, dp[i]);
        }
        return len - max;
    }
    
    // method 2 greedy algorithm fastest
    public int eraseOverlapIntervals2(int[][] intervals) {
        int len = intervals.length;
        if (len < 2) return 0;
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1, last = intervals[0][1];
        for (int i = 1; i < len; i++) {
            if (intervals[i][0] >= last) {
                last = intervals[i][1];
                count++;
            }
        }
        return len - count;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } };
        System.out.println(new NonOverlappingIntervals().eraseOverlapIntervals2(intervals));
    }

}
