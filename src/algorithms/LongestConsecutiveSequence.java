package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    // method 1 disjoint set (union-find)
    public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);
        int longest = 0;
        for (int i : nums) {
            if (!set.contains(i - 1)) {
                int num = i, tmp = 1;
                while (set.contains(++num))
                    tmp++;
                longest = longest > tmp ? longest : tmp;
            }
        }
        return longest;
    }
    
    // method 2 fastest
    public int longestConsecutive2(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        Arrays.sort(nums);
        int longest = 1, tmp = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) continue;
            else if (nums[i - 1] + 1 == nums[i])
                tmp++;
            else {
                longest = longest > tmp ? longest : tmp;
                tmp = 1;
            }
        }
        return longest > tmp ? longest : tmp;
    }

    public static void main(String[] args) {
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(new LongestConsecutiveSequence().longestConsecutive2(nums));
    }

}
