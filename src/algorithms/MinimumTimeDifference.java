package algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTimeDifference {

    public int findMinDifference(List<String> timePoints) {
        Collections.sort(timePoints);
        int diff = Integer.MAX_VALUE, len = timePoints.size();
        for (int i = 1; i < len; i++)
            diff = Math.min(diff, minutes(timePoints.get(i))
                    - minutes(timePoints.get(i - 1)));
        return Math.min(diff, minutes(timePoints.get(0)) + minutes("24:00")
                - minutes(timePoints.get(len - 1)));
    }

    private int minutes(String time) {
        char[] cs = time.toCharArray();
        return ((cs[0] - '0') * 10 + (cs[1] - '0')) * 60 + (cs[3] - '0') * 10
                + (cs[4] - '0');
    }

    public static void main(String[] args) {
        List<String> timePoints = Arrays.asList("00:00", "23:59", "00:00");
        System.out.println(new MinimumTimeDifference().findMinDifference(timePoints));
    }

}
