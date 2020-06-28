package algorithms;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private void quickSort(int[] nums, int left, int right) {
        if (nums.length < 2 || left >= right) return;
        int lo = left, hi = right, pivot = nums[lo + hi >>> 1];
        while (lo <= hi) {
            while (nums[lo] > pivot) lo++;
            while (nums[hi] < pivot) hi--;
            if (lo < hi) {
                int t = nums[lo];
                nums[lo] = nums[hi];
                nums[hi] = t;
                lo++; hi--;
            } else if (lo == hi) lo++;
        }
        quickSort(nums, left, hi);
        quickSort(nums, lo, right);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, 4));
    }

}
