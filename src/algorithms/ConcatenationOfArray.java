package algorithms;

import java.util.Arrays;

public class ConcatenationOfArray {

    public int[] getConcatenation(int[] nums) {
        int[] arr = new int[2 * nums.length];
        for (int i = 0; i < nums.length; i++)
            arr[i] = arr[i + nums.length] = nums[i];
        return arr;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        System.out.println(Arrays.toString(new ConcatenationOfArray().getConcatenation(nums)));
    }

}
