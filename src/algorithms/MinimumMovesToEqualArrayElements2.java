package algorithms;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements2 {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int mid = nums[nums.length >> 1], move = 0;
        for (int num : nums)
            move += Math.abs(num - mid);
        return move;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 10, 2, 9 };
        System.out.println(new MinimumMovesToEqualArrayElements2().minMoves2(nums));
    }

}
