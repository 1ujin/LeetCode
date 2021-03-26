package algorithms;

import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0)
            nums1[m + n - 1] = nums1[m - 1] > nums2[n - 1] ? nums1[--m] : nums2[--n];
        while (n-- > 0)
            nums1[n] = nums2[n];
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 3, 0, 0, 0 }, nums2 = { 2, 5, 6 };
        new MergeSortedArray().merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }

}
