package algorithms;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0, j = 1;
        for (; j < nums.length; j++)
            if (nums[i] != nums[j])
                nums[++i] = nums[j];
        return ++i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        long startTime = System.nanoTime();
        int len = removeDuplicates(nums);
        long endTime = System.nanoTime();
        int[] newNums = new int[len];
        System.arraycopy(nums, 0, newNums, 0, len);
        System.out.println(Arrays.toString(newNums));
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
