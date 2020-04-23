package lcof;

public class Solution51 {
    
    int count = 0;

    public int reversePairs(int[] nums) {
        int[] arr = new int[nums.length];
        recur(nums, arr, 0, nums.length - 1);
        return count;
    }

    private void recur(int[] nums, int[] arr, int begin, int end) {
        if (begin >= end) return;
        int mid = begin + end >> 1;
        int begin1 = begin, end1 = mid, begin2 = mid + 1, end2 = end;
        recur(nums, arr, begin1, end1);
        recur(nums, arr, begin2, end2);
        int i = begin;
        while (begin1 <= end1 && begin2 <= end2) {
            if (nums[begin1] <= nums[begin2])
                arr[i++] = nums[begin1++];
            else {
                arr[i++] = nums[begin2++];
                count += mid - begin1 + 1;
            }
        }
        while (begin1 <= end1)
            arr[i++] = nums[begin1++];
        while (begin2 <= end2)
            arr[i++] = nums[begin2++];
        for (i = begin; i <= end; i++)
            nums[i] = arr[i];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 3, 1 };
        System.out.println(new Solution51().reversePairs(nums));
    }

}
