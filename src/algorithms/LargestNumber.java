package algorithms;

import java.util.Arrays;
import java.util.Objects;

public class LargestNumber {

    // method 1
    public String largestNumber1(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++)
            strs[i] = String.valueOf(nums[i]);
        Arrays.sort(strs, (a, b) -> (b + a).compareTo(a + b));
        if (strs[0].equals("0"))
            return "0";
        StringBuilder sb = new StringBuilder();
        Arrays.stream(strs).forEach(sb::append);
        return sb.toString();
    }

    // method 2
    public String largestNumber2(int[] nums) {
        return Arrays.stream(nums).boxed().map(Objects::toString)
                .sorted((a, b) -> (b + a).compareTo(a + b))
                .reduce(String::concat).filter(s -> !s.startsWith("0"))
                .orElse("0");
    }

    public static void main(String[] args) {
        int[] nums = { 3, 30, 34, 5, 9 };
        System.out.println(new LargestNumber().largestNumber1(nums));
    }

}
