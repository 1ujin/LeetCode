package algorithms;

import java.util.Arrays;

public class MoveZeroes {
    
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            nums[j] = nums[i];
            if (nums[j] != 0) j++;
        }
        for (; j < nums.length; j++)
            nums[j] = 0;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        new MoveZeroes().moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
