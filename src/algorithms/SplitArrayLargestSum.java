package algorithms;

public class SplitArrayLargestSum {

    // method 1 dynamic programming
    public int splitArray1(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = Integer.MAX_VALUE;
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++)
            sub[i + 1] = sub[i] + nums[i];
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= Math.min(i, m); j++)
                for (int k = 0; k < i; k++)
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[k][j - 1], sub[i] - sub[k]));
        return dp[n][m];
    }

    // method 2 binary search fastest
    public int splitArray2(int[] nums, int m) {
        int lo = 0, hi = 0, len = nums.length;
        for (int i = 0; i < len; i++) {
            hi += nums[i];
            if (lo < nums[i])
                lo = nums[i];
        }
        // 二分查找
        while (lo < hi) {
            // 防止 mid 溢出
            int mid = (hi - lo >> 1) + lo, sum = 0, count = 1;
            for (int i = 0; i < len; i++) {
                if (sum + nums[i] > mid) {
                    sum = nums[i];
                    count++;
                } else sum += nums[i];
            }
            if (count > m)
                lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = { 7, 2, 5, 10, 8 };
        System.out.println(new SplitArrayLargestSum().splitArray2(nums, 2));
    }

}
