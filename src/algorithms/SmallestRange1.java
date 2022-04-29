package algorithms;

import java.util.Arrays;

public class SmallestRange1 {

    public int smallestRangeI(int[] nums, int k) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int score = max - min - 2 * k;
        return score <= 0 ? 0 : score;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 6 };
        System.out.println(new SmallestRange1().smallestRangeI(nums, 3));
    }

}
