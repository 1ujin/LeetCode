package lcof;

import java.util.ArrayList;
import java.util.List;

public class Solution57II {
    
    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        for (int i = target / 2; i > 1 ; i--) {
            double mid = (double) target / i;
            if (mid * 2 % 1 != 0 || (mid * 2 % 2 == 0 && i % 2 == 0) || (mid * 2 % 2 != 0 && i % 2 != 0)) continue;
            int start = (int) mid - (i - 1) / 2;
            if (start < 1) continue;
            int[] tmp = new int[i];
            for (int j = 0; j < i; j++)
                tmp[j] = start + j;
            list.add(tmp);
        }
        return list.toArray(new int[list.size()][]);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        new Solution57II().findContinuousSequence(100);
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
