package algorithms;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        if (k == 0)
            return true;
        int len = nums.length;
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++)
            sums[i] = sums[i - 1] + nums[i - 1];
        for (int i = 2; i <= len; i++) {
            if (sums[i] < k && sums[i] != sums[i - 2])
                continue;
            for (int j = 0; j < i - 1; j++)
                if ((sums[i] - sums[j]) % k == 0)
                    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 23, 2, 6, 4, 7 };
        System.out.println(new ContinuousSubarraySum().checkSubarraySum(nums, 6));
    }

}
