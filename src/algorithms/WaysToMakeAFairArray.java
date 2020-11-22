package algorithms;

public class WaysToMakeAFairArray {
    
    public int waysToMakeFair(int[] nums) {
        int len = nums.length, sum = 0, count = 0;
        int[] evenSum = new int[len], oddSum = new int[len];
        for (int num : nums)
            sum += num;
        evenSum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            if (i % 2 == 1) evenSum[i] = evenSum[i - 1];
            else evenSum[i] = nums[i] + evenSum[i - 1];
        }
        oddSum[len - 1] = len % 2 == 0 ? nums[len - 1] : 0;
        for (int i = len - 2; i >= 0; i--) {
            if (i % 2 == 0) oddSum[i] = oddSum[i + 1];
            else oddSum[i] = nums[i] + oddSum[i + 1];
        }
        for (int i = 0; i < len; i++)
            if ((sum - nums[i]) % 2 == 0 && evenSum[i] - nums[i] + oddSum[i] == (sum - nums[i]) / 2)
                count++;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 1, 6, 4 };
        System.out.println(new WaysToMakeAFairArray().waysToMakeFair(nums));
    }

}
