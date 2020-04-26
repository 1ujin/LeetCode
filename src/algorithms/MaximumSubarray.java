package algorithms;

public class MaximumSubarray {
    
    // method 1 dynamic programming
    public int maxSubArray1(int[] nums) {
        int max = nums[0], tmp = max;
        for (int i = 1; i < nums.length; i++) {
            if (tmp <= 0) tmp = nums[i];
            else tmp += nums[i];
            max = max > tmp ? max : tmp;
        }
        return max;
    }
    
    // method 2 divide and conquer
    public int maxSubArray2(int[] nums) {
        return divideConquer(nums, 0, nums.length - 1);
    }

    private int divideConquer(int[] nums, int begin, int end) {
        if (begin >= end) return nums[begin];
        int mid = begin + end >> 1;
        int leftMax = divideConquer(nums, begin, mid);
        int rightMax = divideConquer(nums, mid + 1, end);
        int max = nums[mid] + nums[mid + 1], tmp = max;
        int left = mid - 1, right = mid + 2;
        while (left >= begin) {
            tmp += nums[left--];
            max = max > tmp ? max : tmp;
        }
        tmp = max;
        while (right <= end) {
            tmp += nums[right++];
            max = max > tmp ? max : tmp;
        }
        return Math.max(max, Math.max(leftMax, rightMax));
    }

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(new MaximumSubarray().maxSubArray2(nums));
    }

}
