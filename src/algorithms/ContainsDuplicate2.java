package algorithms;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
            if (i >= k)
                set.remove(nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 2, 3 };
        System.out.println(new ContainsDuplicate2().containsNearbyDuplicate(nums, 2));
    }

}
