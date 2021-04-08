package algorithms;

public class FindMinimumInRotatedSortedArray2 {

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (nums[mid] < nums[hi])
                hi = mid;
            else if (nums[mid] > nums[hi])
                lo = mid + 1;
            else
                hi--;
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 0, 1 };
        System.out.println(new FindMinimumInRotatedSortedArray2().findMin(nums));
    }

}
