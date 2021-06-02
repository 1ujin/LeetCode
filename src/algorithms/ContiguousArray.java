package algorithms;

import java.util.Arrays;

public class ContiguousArray {

    public int findMaxLength(int[] nums) {
        int count = 0, max = 0, len = nums.length;
        int[] dp = new int[(len << 1) + 1];
        Arrays.fill(dp, -1);
        for (int i = 0; i < len; i++) {
            count += nums[i] == 0 ? 1 : -1;
            if (count == 0)
                max = i + 1;
            else if (dp[count + len] != -1)
                max = Math.max(max, i - dp[count + len]);
            else
                dp[count + len] = i;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 0, 1, 1 };
        System.out.println(new ContiguousArray().findMaxLength(nums));
    }

}
