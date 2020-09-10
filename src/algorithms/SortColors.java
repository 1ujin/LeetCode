package algorithms;

import java.util.Arrays;

public class SortColors {

    // method 1
    public void sortColors1(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        for (int i = 0; i <= hi; i++) {
            if (nums[i] == 0) {
                int tmp = nums[i];
                nums[i] = nums[lo];
                nums[lo] = tmp;
                lo++;
            }
            if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[hi];
                nums[hi] = tmp;
                hi--;
                i--;
            }
        }
    }
    
    // method 2
    public void sortColors2(int[] nums) {
        // 对于所有 idx < i : nums[idx < i] = 0
        // j 是当前考虑元素的下标
        int p0 = 0, curr = 0;
        // 对于所有 idx > k : nums[idx > k] = 2
        int p2 = nums.length - 1;
        int tmp;
        while (curr <= p2) {
            if (nums[curr] == 0) {
                // 交换第 p0 个和第 curr 个元素
                // i++，j++
                tmp = nums[p0];
                nums[p0++] = nums[curr];
                nums[curr++] = tmp;
            } else if (nums[curr] == 2) {
                // 交换第 k 个和第 curr 个元素
                // p2--
                tmp = nums[curr];
                nums[curr] = nums[p2];
                nums[p2--] = tmp;
            } else curr++;
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 0, 2, 1, 1, 0 };
        new SortColors().sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }

}
