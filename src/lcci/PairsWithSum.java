package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairsWithSum {
    
    public List<List<Integer>> pairSums(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length, lo = 0, hi = len - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) lo++;
            else if (sum > target) hi--;
            else result.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new PairsWithSum().pairSums(new int[] {5, 6, 5, 6}, 11));
    }

}
