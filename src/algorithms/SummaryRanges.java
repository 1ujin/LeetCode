package algorithms;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int len = nums.length;
        if (len == 0)
            return list;
        StringBuilder sb = new StringBuilder();
        int begin = nums[0];
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1] + 1)
                continue;
            if (nums[i - 1] == begin)
                list.add(String.valueOf(begin));
            else {
                sb.append(begin);
                sb.append("->");
                sb.append(nums[i - 1]);
                list.add(sb.toString());
                sb = new StringBuilder();
            }
            begin = nums[i];
        }
        if (nums[len - 1] == begin) {
            list.add(String.valueOf(begin));
        } else {
            sb.append(begin);
            sb.append("->");
            sb.append(nums[len - 1]);
            list.add(sb.toString());
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 2, 3, 4, 6, 8, 9 };
        System.out.println(new SummaryRanges().summaryRanges(nums));
    }

}
