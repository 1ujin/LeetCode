package algorithms;

import java.util.Arrays;

public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        int len = intervals.length;
        int[][] begins = new int[len][2];
        for (int i = 0; i < len; i++) {
            begins[i][0] = intervals[i][0];
            begins[i][1] = i;
        }
        Arrays.sort(begins, (a, b) -> a[0] - b[0]);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            int lo = 0, hi = len - 1, tar = -1;
            while (lo <= hi) {
                int mid = lo + hi >> 1;
                if (intervals[i][1] <= begins[mid][0]) {
                    tar = begins[mid][1];
                    hi = mid - 1;
                } else
                    lo = mid + 1;
            }
            arr[i] = tar;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 4 }, { 2, 3 }, { 3, 4 } };
        System.out.println(Arrays.toString(new FindRightInterval()
                .findRightInterval(intervals)));
    }

}
