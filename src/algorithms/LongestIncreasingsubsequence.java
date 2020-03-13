package algorithms;

public class LongestIncreasingsubsequence {
    
    // method 1 dynamic programming
    public int lengthOfLIS1(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[dp.length - 1] = 1;
        for (int i = dp.length - 2; i > -1 ; i--) {
            int tmp = 1;
            for (int j = dp.length - 1; j > i; j--)
                tmp = nums[i] < nums[j] && dp[j] + 1 > tmp ? dp[j] + 1 : tmp;
            dp[i] = tmp;
        }
        int max = 0;
        for (int i : dp)
            max = max > i ? max : i;
        return max;
    }
    
    // method 2 binary search
    public int lengthOfLIS2(int[] nums) {
        int max = 0;
        int[] tails = new int[nums.length];
        for (int num : nums) {
            int i = 0, j = max;
            while (i < j) {
                int mid = (i + j) / 2;
                if (tails[mid] < num) i = mid + 1;
                else j = mid;
            }
            tails[i] = num;
            if (max == j) max++;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new LongestIncreasingsubsequence().lengthOfLIS2(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
