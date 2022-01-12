package algorithms;

public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex(int[] nums) {
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++)
            if (nums[i] > nums[maxIndex])
                maxIndex = i;
        for (int i = 0; i < nums.length; i++)
            if (i != maxIndex && nums[i] * 2 > nums[maxIndex])
                return -1;
        return maxIndex;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 6, 1, 0 };
        System.out.println(new LargestNumberAtLeastTwiceOfOthers().dominantIndex(nums));
    }

}
