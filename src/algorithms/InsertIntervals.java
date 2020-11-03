package algorithms;

import java.util.Arrays;

public class InsertIntervals {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length, lo = 0, hi = len - 1, left = 0, right = 0;
        if (len == 0) return new int[][] { newInterval };
        while (lo < len && intervals[lo][1] < newInterval[0]) lo++;
        if (lo == len) {
            int[][] newIntervals = new int[len + 1][2];
            System.arraycopy(intervals, 0, newIntervals, 0, len);
            newIntervals[len] = newInterval;
            return newIntervals;
        } else left = Math.min(intervals[lo][0], newInterval[0]);
        while (hi > -1 && intervals[hi][0] > newInterval[1]) hi--;
        if (hi == -1) {
            int[][] newIntervals = new int[len + 1][2];
            System.arraycopy(intervals, 0, newIntervals, 1, len);
            newIntervals[0] = newInterval;
            return newIntervals;
        } else right = Math.max(intervals[hi][1], newInterval[1]);
        int[][] newIntervals = new int[len - hi + lo][2];
        System.arraycopy(intervals, 0, newIntervals, 0, lo); 
        newIntervals[lo] = new int[] { left, right };
        System.arraycopy(intervals, hi + 1, newIntervals, lo + 1, len - hi - 1);
        return newIntervals;
    }
    
    public static void main(String[] args) {
        int[][] intervals = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
        int[] newInterval = { 4, 8 };
        System.out.println(Arrays.deepToString(new InsertIntervals().insert(intervals, newInterval)));
    }

}
