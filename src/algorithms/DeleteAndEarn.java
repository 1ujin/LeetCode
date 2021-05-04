package algorithms;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int len = 0;
        for (int num : nums)
            len = Math.max(len, num);
        int[] dp = new int[len + 1];
        for (int num : nums)
            dp[num] += num;
        for (int i = 2; i <= len; i++)
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + dp[i]);
        return dp[len];
    }

    public static void main(String[] args) {
        int[] nums = { 4, 10, 10, 8, 1, 4, 10, 9, 7, 6 };
        System.out.println(new DeleteAndEarn().deleteAndEarn(nums));
    }

}
