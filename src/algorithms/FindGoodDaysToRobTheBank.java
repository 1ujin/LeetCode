package algorithms;

import java.util.ArrayList;
import java.util.List;

public class FindGoodDaysToRobTheBank {

    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int len = security.length;
        int[] preSum = new int[len], sufSum = new int[len];
        for (int i = 1; i < len; i++) {
            if (security[i] <= security[i - 1])
                preSum[i] = preSum[i - 1] + 1;
            if (security[len - i - 1] <= security[len - i])
                sufSum[len - i - 1] = sufSum[len - i] + 1;
        }
        List<Integer> days = new ArrayList<>();
        for (int i = time; i < len - time; i++)
            if (preSum[i] >= time && sufSum[i] >= time)
                days.add(i);
        return days;
    }

    public static void main(String[] args) {
        int[] security = { 5, 3, 3, 3, 5, 6, 2 };
        System.out.println(new FindGoodDaysToRobTheBank()
                .goodDaysToRobBank(security, 2));
    }

}
