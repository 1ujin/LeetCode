package lcci;

import java.util.Arrays;

public class PeaksAndValleys {
    
    // method 1
    public void wiggleSort1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int[] odds = Arrays.copyOfRange(nums, len / 2, len);
        int[] evens = Arrays.copyOf(nums, len / 2);
        for (int i = 0; i < odds.length; i++)
            nums[i * 2] = odds[i];
        for (int i = 0; i < len / 2; i++)
            nums[i * 2 + 1] = evens[i];
    }
    
    // method 2
    public void wiggleSort2(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 1 && nums[i] > nums[i - 1]) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            } else if ((i & 1) == 0 && nums[i] < nums[i - 1]) {
                int tmp = nums[i];
                nums[i] = nums[i - 1];
                nums[i - 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {5, 3, 1, 2, 3};
        new PeaksAndValleys().wiggleSort2(nums);
        System.out.println(Arrays.toString(nums));
    }

}
