package algorithms;

import java.util.Arrays;

public class HowManyNumbersAreSmallerThanTheCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101];
        for (int i = 0; i < nums.length; i++)
            count[nums[i]]++;
        for (int i = 1; i < 101; i++)
            count[i] += count[i - 1];
        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                nums[i] = count[nums[i] - 1];
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 8, 1, 2, 2, 3 };
        System.out.println(Arrays.toString(new HowManyNumbersAreSmallerThanTheCurrentNumber().smallerNumbersThanCurrent(nums)));
    }

}
