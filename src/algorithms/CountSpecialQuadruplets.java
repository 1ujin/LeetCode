package algorithms;

import java.util.HashMap;
import java.util.Map;

public class CountSpecialQuadruplets {

    public int countQuadruplets(int[] nums) {
        int len = nums.length, count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int b = len - 3; b > 0; b--) {
            for (int d = b + 2; d < len; d++)
                map.put(nums[d] - nums[b + 1],
                        map.getOrDefault(nums[d] - nums[b + 1], 0) + 1);
            for (int a = 0; a < b; a++)
                count += map.getOrDefault(nums[a] + nums[b], 0);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 3, 5 };
        System.out.println(new CountSpecialQuadruplets().countQuadruplets(nums));
    }

}
