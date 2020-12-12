package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    
    // method 1 fastest
    public boolean containsDuplicate1(int[] nums) {
        int len = nums.length;
        if (len < 2) return false;
        for (int i = 1; i < len; i++) {
            if (nums[i - 1] == nums[i]) return true;
            if (nums[i - 1] < nums[i]) continue;
            for (int j = i - 2; j >= 0; j--)
                if (nums[i] == nums[j]) return true;
            int tmp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = tmp;
        }
        return false;
    }
    
    // method 2
    public boolean containsDuplicate2(int[] nums) {
        return Arrays.stream(nums).distinct().count() < nums.length;
    }
    
    // method 3
    public boolean containsDuplicate3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        return !(set.size() == nums.length);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 3, 4, 3, 2, 4, 2 };
        System.out.println(new ContainsDuplicate().containsDuplicate1(nums));
    }

}
