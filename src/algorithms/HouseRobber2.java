package algorithms;

public class HouseRobber2 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        int[] dp1 = new int[len + 1], dp2 = new int[len + 1];
        for (int i = 2; i <= len; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i - 2]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
        }
        return Math.max(dp1[len], dp2[len]);
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(new HouseRobber2().rob(nums));
    }

}
