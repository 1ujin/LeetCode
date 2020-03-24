package lcci;

public class TheMasseuse {
    
    // dynamic programming
    public int massage(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 0; i < len - 2; i++) {
            int tmp = dp[i] + nums[i + 2];
            dp[i + 2] = dp[i + 1] > tmp ? dp[i + 1] : tmp;
        }
        return dp[len - 1] > dp[len - 2] ? dp[len - 1] : dp[len - 2];
    }
    
    // time limit exceeded
    private int sum;
    
    public int massageTLE(int[] nums) {
        recursive(nums, -2, 0);
        return this.sum;
    }
    
    private void recursive(int[] nums, int index, int sum) {
        if (index > -1) sum += nums[index];
        if (index + 2 < nums.length) recursive(nums, index + 2, sum);
        if (index + 3 < nums.length) recursive(nums, index + 3, sum);
        else this.sum = this.sum > sum ? this.sum : sum;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new TheMasseuse().massage(new int[] {2, 7, 9, 3, 1});
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
