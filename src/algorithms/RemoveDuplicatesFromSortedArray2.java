package algorithms;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray2 {

    public int removeDuplicates(int[] nums) {
        int slow = 1, count = 1;
        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[fast - 1]) count++;
            else count = 1;
            if (count <= 2) nums[slow++] = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 1, 2, 3, 3 };
        System.out.println(new RemoveDuplicatesFromSortedArray2().removeDuplicates(nums)); // 7
        System.out.println(Arrays.toString(nums)); // [0, 0, 1, 1, 2, 3, 3, 3, 3]
    }

}
