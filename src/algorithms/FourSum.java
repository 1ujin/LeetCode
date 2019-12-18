package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    
	// method 1
    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) return result;
        Arrays.sort(nums);
        int i = 0, j = 1, l = 2, r = nums.length - 1;
        while (i < nums.length - 3 && nums[i] * 4 <= target) {
            while (j < nums.length - 2) {
                if (nums[i] + nums[j] + nums[l] + nums[r] == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                } else if (nums[i] + nums[j] + nums[l] + nums[r] < target) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
                if (l >= r) {
                    while (j < nums.length - 3 && nums[j] == nums[j + 1]) j++;
                    j++;
                    l = j + 1;
                    r = nums.length - 1;
                }
            }
            while (i < nums.length - 4 && nums[i] == nums[i + 1]) i++;
            i++;
            j = i + 1;
            l = j + 1;
            r = nums.length - 1;
        }
        return result;
    }
    
    // method 2 fastest
    public static List<List<Integer>> fourSum2(int[] nums, int target) {
        /* 定义一个返回值 */
        List<List<Integer>> result = new ArrayList<>();
        /* 当数组为null或元素小于4个时，直接返回 */
        if (nums == null || nums.length < 4) {
            return result;
        }
        /* 对数组进行从小到大排序 */
        Arrays.sort(nums);
        /* 数组长度 */
        int length = nums.length;
        /* 定义4个指针k，i，j，h  k从0开始遍历，i从k+1开始遍历，留下j和h，j指向i+1，h指向数组最大值 */
        for(int k = 0; k < length - 3; k++) {
            /* 当k的值与前面的值相等时忽略 */
            if (k > 0 && nums[k] == nums[k - 1]) {
                continue;
            }
            /* 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏 */
            int min1 = nums[k] + nums[k + 1] + nums[k + 2] + nums[k + 3];
            if (min1 > target) {
                break;
            }
            /* 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略 */
            int max1 = nums[k] + nums[length - 1] + nums[length - 2] + nums[length - 3];
            if (max1 < target) {
                continue;
            }
            /* 第二层循环i，初始值指向k+1 */
            for(int i = k + 1; i < length - 2; i++) {
                /* 当i的值与前面的值相等时忽略 */
                if (i > k + 1 && nums[i] == nums[i - 1]) {
                    continue;
                }
                /* 定义指针j指向i+1 */
                int j = i + 1;
                /* 定义指针h指向数组末尾 */
                int h = length - 1;
                /* 获取当前最小值，如果最小值比目标值大，说明后面越来越大的值根本没戏，忽略 */
                int min = nums[k] + nums[i] + nums[j] + nums[j+1];
                if (min > target) {
                    continue;
                }
                /* 获取当前最大值，如果最大值比目标值小，说明后面越来越小的值根本没戏，忽略 */
                int max = nums[k] + nums[i] + nums[h] + nums[h - 1];
                if (max < target) {
                    continue;
                }
                /* 开始j指针和h指针的表演，计算当前和，如果等于目标值，j++并去重，h--并去重，当当前和大于目标值时h--，当当前和小于目标值时j++ */
                while (j < h) {
                    int curr = nums[k] + nums[i] + nums[j] + nums[h];
                    if (curr == target) {
                        result.add(Arrays.asList(nums[k], nums[i], nums[j], nums[h]));
                        j++;
                        while(j < h && nums[j] == nums[j - 1]) {
                            j++;
                        }
                        h--;
                        while(j < h && i < h && nums[h] == nums[h + 1]) {
                            h--;
                        }
                    } else if (curr > target) {
                        h--;
                    } else {
                        j++;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        fourSum1(new int[] {-1,0,1,2,-1,-4}, -1);
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
