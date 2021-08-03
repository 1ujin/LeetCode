package algorithms;

import java.util.Arrays;

public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0, len = nums.length;
        for (int i = 0; i < len - 2; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                int k = j, lo = k + 1, hi = len - 1;
                while (lo <= hi) {
                    int mid = lo + hi >> 1;
                    if (nums[i] + nums[j] > nums[mid]) {
                        lo = mid + 1;
                        k = mid;
                    } else
                        hi = mid - 1;
                }
                count += k - j;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 4 };
        System.out.println(new ValidTriangleNumber().triangleNumber(nums));
    }

}
