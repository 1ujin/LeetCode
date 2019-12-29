package algorithms;

import java.util.Arrays;

public class NextPermutation {
    
    public static void nextPermutation(int[] nums) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == 0) {
                Arrays.sort(nums);
            } else if (nums[i] > nums[i - 1]) {
                int tmpIndex = i;
                for (int j = i; j < nums.length; j++) {
                    tmpIndex = nums[tmpIndex] > nums[j] && nums[j] > nums[i - 1] ? j : tmpIndex;
                }
                int tmp = nums[tmpIndex];
                nums[tmpIndex] = nums[i - 1];
                nums[i - 1] = tmp;
                Arrays.sort(nums, i, nums.length);
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 2, 1};
        long startTime = System.nanoTime();
        nextPermutation(nums);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(nums));
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
