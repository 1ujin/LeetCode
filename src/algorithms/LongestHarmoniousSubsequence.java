package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    // method 1
    public int findLHS1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);
        int res = 0;
        for (int key : map.keySet())
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        return res;
    }

    // method 2 fastest
    public int findLHS2(int[] nums) {
        int i = 0, j = 1, len = nums.length, res = 0;
        Arrays.sort(nums);
        while (j < len) {
            while (j < len && nums[j] <= nums[i] + 1)
                j++;
            if (nums[j - 1] != nums[i] + 1) {
                i = j;
                continue;
            }
            if (j - i > res)
                res = j - i;
            i++;
            while (i < len && nums[i - 1] == nums[i])
                i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        System.out.println(new LongestHarmoniousSubsequence().findLHS2(nums));
    }

}
