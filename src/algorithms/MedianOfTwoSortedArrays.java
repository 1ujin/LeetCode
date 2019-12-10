package algorithms;

import java.util.Arrays;

public class MedianOfTwoSortedArrays {
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length, i = 0, j = 0;
		double result = 0, tmp = 0;
		
		if (nums1.length == 0) {
			if (nums2.length % 2 == 0) {
				return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2.0;
			} else {
				return nums2[nums2.length / 2];
			}
		}
		
		if (nums2.length == 0) {
			if (nums1.length % 2 == 0) {
				return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2.0;
			} else {
				return nums1[nums1.length / 2];
			}
		}
		
		if (count % 2 == 0) count++;
		
		for (int k = 0; k < (count + 1) / 2; k++) {
			tmp = result;
			if (i == nums1.length) {
	            while (i + j != (count + 1) / 2) {
	                if (result < nums2[j]) {
	                	tmp = result;
						result = (double) nums2[j];
					}
	                j++;
	            }
	            break;
	        }
			
	        if (j == nums2.length) {
	            while (i + j != (count + 1) / 2) {
	            	if (result < nums1[i]) {
	            		tmp = result;
						result = (double) nums1[i];
					}
	            	i++;
	            }
	            break;
	        }
	        
	        if (nums1[i] < nums2[j]) {
	            result = nums1[i];
	            i++;
	        } else {
	            result = nums2[j];
	            j++;
	        }

		}
		
		if ((nums1.length + nums2.length) % 2 == 0) {
			System.out.println(tmp);
			System.out.println(result);
			return (tmp + result) / 2;
		}
		return result;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {1};
		int[] nums2 = new int[] {2, 3, 4};
		System.out.println(findMedianSortedArrays(nums1, nums2));
	}

}
