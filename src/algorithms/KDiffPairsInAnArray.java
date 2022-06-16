package algorithms;

import java.util.Arrays;

public class KDiffPairsInAnArray {

    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length, count = 0;
        for (int i = 0, j = 0; i < len; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            while (j < len && (nums[j] < nums[i] + k || j <= i))
                j++;
            if (j < len && nums[j] == nums[i] + k)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 1, 5 };
        System.out.println(new KDiffPairsInAnArray().findPairs(nums, 2));
    }

}
