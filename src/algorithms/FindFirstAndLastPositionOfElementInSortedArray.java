package algorithms;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    
    // method 1
    public static int[] searchRange1(int[] nums, int target) {
        int[] positions = new int[] {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                positions[0] = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                positions[1] = i;
                break;
            }
        }
        return positions;
    }
    
    // method 2 binary search
    public static int[] searchRange2(int[] nums, int target) {
        int[] positions = new int[] {-1, -1};
        int left = 0, right = nums.length;
        // 查找第一个位置
        while (left < right) {
            int mid = (left + right) / 2;
            // 使左侧区间的数全部小于目标值，分界处即所有目标数的左边界
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(left);
        // 检查位置是否在数组中，是否到达第一个位置且等于目标值
        if (left == nums.length || nums[left] != target) {
            return positions;
        }
        positions[0] = left;
        left = 0;
        right = nums.length;
        // 查找最后一个位置
        while (left < right) {
            int mid = (left + right) / 2;
            // 使左侧区间的数全部大于目标值，分界处即所有目标数的右边界
            if (nums[mid] > target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        positions[1] = left - 1;
        return positions;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int[] positions = searchRange2(new int[] {5, 7, 7, 8, 8, 10}, 8);
        long endTime = System.nanoTime();
        System.out.println(Arrays.toString(positions));
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
