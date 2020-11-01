package algorithms;

import java.util.Arrays;

public class IntersectionOfTwoArrays {
    
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length, len2 = nums2.length;
        int[] nums = new int[len1 < len2 ? len1 : len2];
        int idx = 0, idx1 = 0, idx2 = 0;
        while (idx1 < len1 && idx2 < len2) {
            if (nums1[idx1] < nums2[idx2])
                idx1++;
            else if (nums1[idx1] > nums2[idx2])
                idx2++;
            else if (idx > 0 && nums[idx - 1] == nums1[idx1])
                idx1++;
            else {
                nums[idx++] = nums1[idx1++];
                idx2++;
            }
        }
        return Arrays.copyOfRange(nums, 0, idx);
    }

    public static void main(String[] args) {
        int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
        System.out.println(Arrays.toString(new IntersectionOfTwoArrays()
                .intersection(nums1, nums2)));
    }

}
