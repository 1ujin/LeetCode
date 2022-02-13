package algorithms;

public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            if (nums[mid] == nums[mid - 1] && (mid - lo) % 2 == 0)
                hi = mid;
            else if (nums[mid] == nums[mid + 1] && (mid - lo) % 2 != 0)
                hi = mid - 1;
            else if (nums[mid] == nums[mid + 1] && (mid - lo) % 2 == 0)
                lo = mid;
            else if (nums[mid] == nums[mid - 1] && (mid - lo) % 2 != 0)
                lo = mid + 1;
            else
                return nums[mid];
        }
        return nums[lo];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 8, 8 };
        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(nums));
    }

}
