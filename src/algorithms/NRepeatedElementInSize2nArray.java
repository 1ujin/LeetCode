package algorithms;

import java.util.HashSet;
import java.util.Set;

public class NRepeatedElementInSize2nArray {

    public int repeatedNTimes(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            if (!set.add(num))
                return num;
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 1, 5, 2, 5, 3, 5, 4 };
        System.out.println(new NRepeatedElementInSize2nArray().repeatedNTimes(nums));
    }

}
