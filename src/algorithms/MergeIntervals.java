package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return intervals;
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        int j = 0, t = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (t >= intervals[i][0]) {
                if (intervals[i][1] > t)
                    result.get(j)[1] = intervals[i][1];
            } else {
                result.add(intervals[i]);
                j++;
            }
            t = result.get(j)[1];
        }
        return result.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        Arrays.stream(new MergeIntervals().merge(intervals))
                .map(Arrays::toString).forEach(System.out::print);
    }

}
