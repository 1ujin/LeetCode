package algorithms;

public class SearchInRotatedSortedArray2 {

    public boolean search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        if (hi < 0) return false;
        while (lo <= hi) {
            int mid = lo + hi >> 1;
            if (nums[mid] == target) return true;
            if (nums[lo] == nums[mid]) {
                lo++;
                continue;
            }
            if (nums[lo] < nums[mid]) {
                if (nums[lo] <= target && nums[mid] > target) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if (nums[mid] < target && nums[hi] >= target) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 6, 0, 0, 1, 2 };
        System.out.println(new SearchInRotatedSortedArray2().search(nums, 0)); // true
        System.out.println(new SearchInRotatedSortedArray2().search(nums, 3)); // false
    }

}
