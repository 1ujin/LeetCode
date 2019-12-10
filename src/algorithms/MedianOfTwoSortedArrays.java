package algorithms;

public class MedianOfTwoSortedArrays {
	
	// method 1
	public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length, i = 0, j = 0;
		double result = 0, preResult = 0;
		
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
			preResult = result;
			if (i == nums1.length) {
	            while (i + j != (count + 1) / 2) {
	                if (result < nums2[j]) {
	                	preResult = result;
						result = (double) nums2[j];
					}
	                j++;
	            }
	            break;
	        }
			
	        if (j == nums2.length) {
	            while (i + j != (count + 1) / 2) {
	            	if (result < nums1[i]) {
	            		preResult = result;
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
			return (preResult + result) / 2;
		}
		return result;
    }
	
	// method 2
	public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
		double median = 0, preMedian = 0;
		int m = 0, n = 0;
		for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
			preMedian = median;
			// m与n不可能同时越界（i遍历总次数的限制）, 如果一方越界则另一方必定不越界且未遍历到目标数
			// 只有不越界，才可以自增
			if (m < nums1.length && (n >= nums2.length || nums1[m] < nums2[n])) {
				// (m不越界 且 n越界) 或 (m不越界 且 nums1[m] < nums2[n])
				median = nums1[m];
				m++;
			} else { // m越界 且 n此时必定不越界 或 (n不越界 且 nums1[m] >= nums2[n])
				median = nums2[n];
				n++;
			}
		}
		
		if ((nums1.length + nums2.length) % 2 == 0) {
			return (preMedian + median) / 2.0;
		}
		
		return median;
	}
	
	// method 3
	public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int left = (m + n + 1) / 2, right = (m + n + 2) / 2;
		return (getKth(nums1, 0, m - 1, nums2, 0, n - 1, left) + getKth(nums1, 0, m - 1, nums2, 0, n - 1, right)) / 2.0;
	}
	
	public static int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
		int len1 = end1 - start1 + 1, len2 = end2 - start2 + 1;
		
		if (len1 > len2) {
			return getKth(nums2, start2, end2, nums1, start1, end1, k);
		}
		
		if (len1 == 0) {
			return nums2[start2 + k - 1];
		}
		
		if (k == 1) {
			return Math.min(nums1[start1], nums2[start2]);
		}
		
		int i = start1 + Math.min(len1, k / 2) - 1, j = start2 + Math.min(len2, k / 2) - 1;
		
		if (nums1[i] > nums2[j]) {
			return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j + start2 + 1));
		} else {
			return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i + start1 + 1));
		}
	}
	
	// method 4
	public static double findMedianSortedArrays4(int[] nums1, int[] nums2) {
		int m = nums1.length;
        int n = nums2.length;
        if (m > n) { 
            return findMedianSortedArrays4(nums2, nums1); // 保证 m <= n
        }
        int iMin = 0, iMax = m;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = (m + n + 1) / 2 - i;
            if (j != 0 && i != m && nums2[j-1] > nums1[i]){ // i 需要增大
                iMin = i + 1; 
            }
            else if (i != 0 && j != n && nums1[i-1] > nums2[j]) { // i 需要减小
                iMax = i - 1; 
            }
            else { // 达到要求，并且将边界条件列出来单独考虑
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; } // 奇数的话不需要考虑右半部分

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0; //如果是偶数的话返回结果
            }
        }
        return 0.0;
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {1};
		int[] nums2 = new int[] {2, 3, 4};
		System.out.println(findMedianSortedArrays4(nums1, nums2));
	}

}
