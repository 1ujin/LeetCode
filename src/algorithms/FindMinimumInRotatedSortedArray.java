package algorithms;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        if (nums[0] < nums[hi])
            return nums[0];
        while (lo < hi - 1) {
            int mid = lo + hi >> 1;
            if (nums[mid] > nums[lo])
                lo = mid;
            else
                hi = mid;
        }
        return nums[hi];
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(nums));
    }

}
