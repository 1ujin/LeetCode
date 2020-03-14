package lcci;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        int bmp = (int) Math.pow(2, nums.length);
        for (int i = 0; i < bmp; i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)
                if ((i >>> j & 1) == 1) subset.add(nums[j]);
            subsets.add(subset);
        }
        return subsets;
    }

    public static void main(String[] args) {
        System.out.println(new PowerSet().subsets(new int[] {1, 2, 3}));
    }

}
