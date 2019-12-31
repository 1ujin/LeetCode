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
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.length || nums[left] != target) {
            return positions;
        }
        positions[0] = left;
        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
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