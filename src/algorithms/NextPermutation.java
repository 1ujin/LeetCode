package algorithms;

import java.util.Arrays;

public class NextPermutation {
    
    public void nextPermutation(int[] nums) {
        int len = nums.length, i = len - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i > -1) {
            int j = len - 1;
            while (j > 0 && nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        while (++i < len--) swap(nums, i, len);
    }

    private void swap (int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 1 };
        long startTime = System.nanoTime();
        new NextPermutation().nextPermutation(nums);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(nums));
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
