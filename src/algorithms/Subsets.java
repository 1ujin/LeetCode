package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> subset = new ArrayList<>();
            int j = i;
            for (int num : nums) {
                if ((j & 1) == 1)
                    subset.add(num);
                j >>= 1;
            }
            subsets.add(subset);
        }
        return subsets;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(new Subsets().subsets(nums));
    }

}
