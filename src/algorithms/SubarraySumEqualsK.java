package algorithms;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 1; i < nums.length; i++)
            nums[i] += nums[i - 1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num : nums) {
            count += map.getOrDefault(num - k, 0);
            map.compute(num, (key, v) -> v == null ? 1 : ++v);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, 3));
    }

}
