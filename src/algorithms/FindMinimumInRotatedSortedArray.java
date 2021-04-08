package algorithms;

public class FindMinimumInRotatedSortedArray {

    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (nums[mid] < nums[hi])
                hi = mid;
            else lo = mid + 1;
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
        System.out.println(new FindMinimumInRotatedSortedArray().findMin(nums));
    }

}
