package lcof;

public class Solution39 {

    public int majorityElement(int[] nums) {
        int len = nums.length;
        mergeSort(nums, new int[len], 0, len - 1);
        return nums[len >> 1];
    }

    private void mergeSort(int[] nums, int[] temp, int begin, int end) {
        if (begin >= end) return;
        int mid = begin + end >> 1;
        int begin1 = begin, end1 = mid, begin2 = mid + 1, end2 = end;
        mergeSort(nums, temp, begin1, end1);
        mergeSort(nums, temp, begin2, end2);
        int i = begin;
        while (begin1 <= end1 && begin2 <= end2)
            temp[i++] = nums[begin1] < nums[begin2] ? nums[begin1++] : nums[begin2++];
        while (begin1 <= end1)
            temp[i++] = nums[begin1++];
        while (begin2 <= end2)
            temp[i++] = nums[begin2++];
        for (i = begin; i <= end; i++)
            nums[i] = temp[i];
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
        System.out.println(new Solution39().majorityElement(nums));
    }

}
