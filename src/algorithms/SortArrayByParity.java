package algorithms;

import java.util.Arrays;

public class SortArrayByParity {

    public int[] sortArrayByParity(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi && lo < nums.length && hi >= 0) {
            int a = nums[lo] % 2, b = nums[hi] % 2;
            if (a != 0 && b == 0) {
                int tmp = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = tmp;
            }
            if (a == 0)
                lo++;
            if (b != 0)
                hi--;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 2, 4 };
        System.out.println(Arrays.toString(new SortArrayByParity()
                .sortArrayByParity(nums)));
    }

}
