package algorithms;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length, i = 0, j = 0;
		double result = 0, tmp = 0;
		if (count % 2 == 0) {
			int[] nums3, nums4;
			if (nums1.length > nums2.length) {
				nums3 = Arrays.copyOf(nums1, (nums1.length + nums2.length) / 2);
				nums4 = Arrays.copyOf(nums2, (nums1.length + nums2.length) / 2);
				System.arraycopy(nums1, (nums1.length + nums2.length) / 2, nums4, nums2.length, (nums1.length - nums2.length) / 2);
			} else {
				nums3 = Arrays.copyOf(nums1, (nums1.length + nums2.length) / 2);
				nums4 = Arrays.copyOf(nums2, (nums1.length + nums2.length) / 2);
				System.arraycopy(nums2, (nums1.length + nums2.length) / 2, nums3, nums1.length, (nums2.length - nums1.length) / 2);
			}
			if (nums3.length == 0 || nums4.length == 0) return nums3.length != 0 ? ((double) nums3[count / 2 - 1] + (double) nums3[count / 2]) / 2 : ((double) nums4[count / 2 - 1] + (double) nums4[count / 2]) / 2;
			for (int k = 0; k <= count / 2; k++) {
				if (i == nums3.length - 1 && j == nums4.length - 1) {
					result = ((double) nums3[j] + (double) nums4[j]) / 2;
				} else if (i == nums3.length - 1) {
					result = (tmp + (double) nums4[j]) / 2;
				} else if (j == nums4.length - 1) {
					result = (tmp + (double) nums3[i]) / 2;
				} else {
					result = (tmp + (nums3[i] < nums4[j] ? (double) nums3[i] : (double) nums4[j])) / 2;
				}
				if (nums3[i] < nums4[j]) {
					tmp = nums3[i];
					if (i < nums3.length - 1) i++;
				} else {
					tmp = nums4[j];
					if (j < nums4.length - 1) j++;
				}
			}
		} else {
			if (nums1.length == 0 || nums2.length == 0) return nums1.length != 0 ? (double) nums1[(count - 1) / 2] : (double) nums2[(count - 1) / 2];
			for (int k = 0; k < (count + 1) / 2; k++) {
				result = nums1[i] < nums2[j] ? nums1[i] : nums2[j];
				if (nums1[i] < nums2[j]) {
					if (i < nums1.length - 1) i++;
				} else {
					if (j < nums2.length - 1) j++;
				}
			}
		}
        return (double) result;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 4};
		int[] nums2 = new int[] {-1, 3};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
