package algorithms;

import java.util.Arrays;

public class RemoveElement {
    
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                if (nums[i] == val) {
                    nums[i] = nums[j];
                    nums[j] = val;
                }
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        long startTime = System.nanoTime();
        int len = removeElement(nums, 2);
        long endTime = System.nanoTime();
        int[] newNums = new int[len];
        System.arraycopy(nums, 0, newNums, 0, len);
        System.out.println(Arrays.toString(newNums));
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
