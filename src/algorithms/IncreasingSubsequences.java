package algorithms;

import java.util.ArrayList;
import java.util.List;

public class IncreasingSubsequences {
    
    int[] nums;
    List<Integer> temp = new ArrayList<>();
    List<List<Integer>> subseqs = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        dfs(0, Integer.MIN_VALUE);
        return subseqs;
    }

    private void dfs(int index, int last) {
        if (index == nums.length) {
            if (temp.size() >= 2)
                subseqs.add(new ArrayList<Integer>(temp));
            return;
        }
        if (nums[index] >= last) {
            temp.add(nums[index]);
            dfs(index + 1, nums[index]);
            temp.remove(temp.size() - 1);
        }
        if (nums[index] != last)
            dfs(index + 1, last);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 1, 2 };
        System.out.println(new IncreasingSubsequences().findSubsequences(nums));
    }

}
