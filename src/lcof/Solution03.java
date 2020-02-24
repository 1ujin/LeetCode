package lcof;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution03 {
    
    // method 1 hash table
    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (set.contains(num)) return num;
            else set.add(num);
        }
        return -1;
    }
    
    // method 2 sort faster
    public int findRepeatNumber2(int[] nums) {
        Arrays.sort(nums);
        int num = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (num == nums[i]) return num;
            else num = nums[i];
        }
        return -1;
    }
    
    // method 3 bitmap fastest
    public int findRepeatNumber3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                int tmp = nums[i];
                if (nums[tmp] == tmp) return nums[i];
                nums[tmp] = nums[i];
                nums[i] = tmp;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution03 solution = new Solution03();
        long startTime = System.nanoTime();
        int result = solution.findRepeatNumber3(new int[] {2, 3, 1, 0, 2, 5, 3});
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
