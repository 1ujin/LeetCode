package algorithms;

import java.util.Arrays;

public class ThreeSumClosest {
    
    // method 1
    public static int threeSumClosest1(int[] nums, int target) {
        if (nums == null) return 0;
        int sum = 0;
        if (nums.length <= 3) {
            for (int i = 0; i < nums.length; i++) sum += nums[i];
            return sum;
        }
        Arrays.sort(nums);
        if (nums[0] * 3 > target) return nums[0] + nums[1] + nums[2];
        int i = 0;
        sum = nums[0] + nums[1] + nums[nums.length - 1];
        while (i < nums.length - 2 && nums[i] * 3 <= target) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                i++;
                continue;
            }
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int tmp = nums[i] + nums[l] + nums[r];
                if (tmp == target) {
                    return target;
                } else if (tmp < target) {
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    l++;
                } else {
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    r--;
                }
                if (Math.abs(tmp - target) < Math.abs(sum - target)) sum = tmp;
            }
            i++;
        }
        return sum;
    }
    
    // method 2 fastest
    public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
        	
            int left = i + 1, right = nums.length - 1;
            
            while (left != right) {
            	// 选出更接近target的边界值作为result可以减小时间复杂度
	            // (2)判断最小值
	            int min = nums[i] + nums[left] + nums[left + 1];
	            
	            if (target < min) {
	            	
	                if (Math.abs(result - target) > Math.abs(min - target)) result = min;
	                
	                break;
	                
	            }
	            // (2)判断最大值
	            int max = nums[i] + nums[right] + nums[right - 1];
	            
	            if (target > max) {
	            	
	                if (Math.abs(result - target) > Math.abs(max - target)) result = max;
	                
	                break;
	                
	            }
	            int sum = nums[i] + nums[left] + nums[right];
	            // (3)判断三数之和是否等于target
	            if (sum == target) return sum;
	            // 比较三数之和sum与最大值max最小值min谁更接近target并保存到result
	            if (Math.abs(sum - target) < Math.abs(result - target)) result = sum;

	            if (sum > target) {
	            	
	                right--;
	                // (1)解决nums[right]重复
	                while (left != right && nums[right] == nums[right + 1]) right--;

	            } else {
	            	
	                left++;
	                // (1)解决nums[left]重复
	                while (left != right && nums[left] == nums[left - 1]) left++;
	                
	            }
            }
            // (1)解决nums[i]重复
            while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;

        }
        return result;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(threeSumClosest1(new int[] {
        		6,-18,-20,-7,-15,9,18,10,1,-20,-17,-19,-3,-5,-19,10,6,-11,1,-17,-15,6,17,-18,-3,16,19,-20,-3,-17,-15,-3,
        		12,1,-9,4,1,12,-2,14,4,-4,19,-20,6,0,-19,18,14,1,-15,-5,14,12,-4,0,-10,6,6,-6,20,-8,-6,5,0,3,10,7,-2,17,
        		20,12,19,-13,-1,10,-1,14,0,7,-3,10,14,14,11,0,-4,-15,-8,3,2,-5,9,10,16,-4,-3,-9,-8,-14,10,6,2,-12,-7,
        		-16,-6,10
        		}, -52));
//        		1, 1, 1, 1
//        		}, 0));
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
