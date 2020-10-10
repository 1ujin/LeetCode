package algorithms;

public class PartitionEqualSubsetSum {
    
    public boolean canPartition(int[] nums) {
        int len = nums.length;
        if (len < 2) return false;
        int sum = 0, max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }
        if ((sum & 1) == 1) return false;
        int half = sum >> 1;
        if (max > half) return false;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            for (int j = half; j >= num; j--)
                dp[j] |= dp[j - num];
        }
        return dp[half];
    }

    public static void main(String[] args) {
        int[] nums = { 14, 9, 8, 4, 3, 2 };
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }

}
