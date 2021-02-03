package algorithms;

public class MaximumAverageSubarray1 {

    // method 1 sum first 先计算总和
    public double findMaxAverage1(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += nums[i];
        int max = sum;
        for (int i = k; i < nums.length; i++)
            max = Math.max(max, sum += nums[i] - nums[i - k]);
        return (double) max / k;
    }

    // method 2 boundary first 先计算边界
    public double findMaxAverage2(int[] nums, int k) {
        int maxLeft = 0, curr = 0, max = 0;
        for (int currLeft = 0; currLeft < nums.length - k; currLeft++) {
            int newRight = currLeft + k;
            curr += nums[newRight] - nums[currLeft];
            if (curr <= 0 || curr <= max)
                continue;
            max = curr;
            maxLeft = currLeft + 1;
        }
        int maxSum = 0;
        for (int i = maxLeft; i < maxLeft + k; i++)
            maxSum += nums[i];
        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        int[] sum = { 1, 12, -5, -6, 50, 3 };
        System.out.println(new MaximumAverageSubarray1().findMaxAverage1(sum, 4));
    }

}
