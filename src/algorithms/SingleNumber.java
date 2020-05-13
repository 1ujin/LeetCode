package algorithms;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    // method 1 bitwise operation
    public int singleNumber1(int[] nums) {
        int xor = 0;
        for (int num : nums)
            xor ^= num;
        return xor;
    }
    
    // method 2 HashSet
    public int singleNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            if (!set.add(num))
                set.remove(num);
        return set.iterator().next();
    }

    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        System.out.println(new SingleNumber().singleNumber2(nums));
    }

}
