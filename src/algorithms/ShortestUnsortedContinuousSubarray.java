package algorithms;

public class ShortestUnsortedContinuousSubarray {

    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length, max = nums[0], min = nums[n - 1];
        int start = 0, end = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] < max)
                end = i;
            else
                max = nums[i];
            if (nums[n - 1 - i] > min)
                start = n - 1 - i;
            else
                min = nums[n - 1 - i];
        }
        return end - start + 1;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
        System.out.println(new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(nums));
    }

}
