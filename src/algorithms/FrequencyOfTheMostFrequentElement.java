package algorithms;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, freq = 1;
        long total = 0l;
        for (int hi = 1; hi < nums.length; hi++) {
            total += (long) (nums[hi] - nums[hi - 1]) * (hi - lo);
            while (total > k)
                total -= nums[hi] - nums[lo++];
            freq = Math.max(freq, hi - lo + 1);
        }
        return freq;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 8, 13 };
        System.out.println(new FrequencyOfTheMostFrequentElement().maxFrequency(nums, 5));
    }

}
