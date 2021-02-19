package algorithms;

import java.util.HashMap;
import java.util.Map;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int index = i;
            map.compute(nums[i], (k, v) -> {
                if (v == null)
                    v = new int[] { 0, index, 0 };
                v[0]++;
                v[2] = index;
                return v;
            });
        }
        int degree = nums.length, freq = 0;
        for (int[] value : map.values()) {
            if (freq == value[0]) {
                degree = Math.min(degree, value[2] - value[1] + 1);
            } else if (freq < value[0]) {
                freq = value[0];
                degree = value[2] - value[1] + 1;
            }
        }
        return degree;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 3, 1, 4, 2 };
        System.out.println(new DegreeOfAnArray().findShortestSubArray(nums));
    }

}
