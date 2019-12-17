package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    
    // method 1 超出时间限制
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int l = 0;
        if (nums.length < 3) return list;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        list.add(new ArrayList<Integer>());
                        list.get(l).add(nums[i]);
                        if (nums[j] > nums[i]) {
                            list.get(l).add(nums[j]);
                        } else {                            
                            list.get(l).add(0, nums[j]);
                        }
                        if (nums[k] > list.get(l).get(1)) {
                            list.get(l).add(nums[k]);
                        } else if (nums[k] < list.get(l).get(0)) {
                            list.get(l).add(0, nums[k]);
                        } else {
                            list.get(l).add(1, nums[k]);
                        }
                        for (int m = 0; m < list.size() - 1; m++) {
                            if (list.get(m).equals(list.get(l))) {
                                list.remove(list.size() - 1);
                                l--;
                                break;
                            }
                        }
                        l++;
                    }
                    
                }
                
            }
            
        }
        return list;
    }
    
    // method 2 fastest
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0;
        while (i < nums.length - 2 && nums[i] <= 0) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (nums[i] + nums[l] + nums[r] == 0) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                	while (l < r && nums[l] == nums[l + 1]) l++;
                	l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
            }
            i++;
        }
        return result;
    }
    
    // method 3
    public static List<List<Integer>> threeSum3(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) return result;
        Arrays.sort(nums);
        int i = 0, l = 1, r = nums.length - 1;
        while (i < nums.length - 2 && nums[i] <= 0) {
        	if (nums[i] + nums[l] + nums[r] == 0) {
                result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                while (l < r && nums[l] == nums[l + 1]) l++;
                l++;
                while (l < r && nums[r] == nums[r - 1]) r--;
                r--;
            } else if (nums[i] + nums[l] + nums[r] < 0) {
            	while (l < r && nums[l] == nums[l + 1]) l++;
            	l++;
            } else {
                while (l < r && nums[r] == nums[r - 1]) r--;
                r--;
            }
        	if (l >= r) {
				while (i < nums.length - 3 && nums[i] == nums[i + 1]) i++;
				i++;
				l = i + 1;
				r = nums.length - 1;
			}
        }
        return result;
	}

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        threeSum3(new int[] {-1, 0, 1, 2, -1, -4});
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
