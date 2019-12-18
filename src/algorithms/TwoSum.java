package algorithms;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            System.out.print(complement);
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            System.out.println(nums[i]);
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
    	long startTime = System.nanoTime();
        twoSum(new int[] {3, 2, 4}, 6);
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
