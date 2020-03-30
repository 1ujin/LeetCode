package lcci;

public class ContiguousSequence {
    
    // method 1 dynamic programming
    public int maxSubArray1(int[] nums) {
        int max = nums[0], tmp = max;
        for (int i = 1; i < nums.length; i++) {
            if (tmp <= 0) tmp = nums[i];
            else tmp += nums[i];
            max = max >= tmp ? max : tmp;
        }
        return max;
    }
    
    // method 2 divide-and-conquer
    public int maxSubArray2(int[] nums) {
        return divideConquer(nums, 0, nums.length - 1);
    }
    
    private int divideConquer(int[] nums, int left, int right) {
        if (left == right) return nums[left];
        int mid = left + right >>> 1;
        // 左半数组和最大值
        int maxLeft = divideConquer(nums, left, mid);
        // 右半数组和最大值
        int maxRight = divideConquer(nums, mid + 1, right);
        // 包含中间元素的子数组和最大值
        int maxMid = nums[mid] + nums[mid + 1];
        int lo = mid - 1, hi = mid + 2;
        int tmp = maxMid;
        while (lo >= left) {
            tmp += nums[lo--];
            maxMid = tmp > maxMid ? tmp : maxMid;
        }
        tmp = maxMid;
        while (hi <= right) {
            tmp += nums[hi++];
            maxMid = tmp > maxMid ? tmp : maxMid;
        }
        return Math.max(Math.max(maxLeft, maxRight), maxMid);
    }

    public static void main(String[] args) {
        System.out.println(new ContiguousSequence().
                maxSubArray2(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
