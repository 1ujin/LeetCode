package lcof;

public class Solution53II {

    public int missingNumber(int[] nums) {
        int len = nums.length;
        if (nums[0] != 0) return 0;
        if (len - 1 == nums[len - 1]) return len;
        int lo = 0, hi = len - 1;
        while (lo + 1 < hi) {
            int mid1 = lo + hi >> 1, mid2 = lo + hi + 1 >> 1;
            if (nums[mid1] - nums[lo] < nums[hi] - nums[mid2])
                lo = mid2;
            else if (nums[mid1] - nums[lo] > nums[hi] - nums[mid2])
                hi = mid1;
            else break;
        }
        return nums[lo] + nums[hi] >> 1;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 3, 4, 5, 6, 7, 9 };
        System.out.println(new Solution53II().missingNumber(nums));
    }

}
