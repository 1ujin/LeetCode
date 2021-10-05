package algorithms;

import java.util.Arrays;

public class ThirdMaxmiumNumber {

    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 2, j = 1; i >= 0; i--) {
            if (nums[i] != nums[i + 1])
                j++;
            if (j == 3)
                return nums[i];
        }
        return nums[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 1 };
        System.out.println(new ThirdMaxmiumNumber().thirdMax(nums));
    }

}
