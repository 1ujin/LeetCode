package algorithms;

public class SumOfSubarrayRanges {

    public long subArrayRanges(int[] nums) {
        long sum = 0L;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int left = i, right = i;
            while (left > 0 && nums[left - 1] < nums[i])
                left--;
            while (right < len - 1 && nums[right + 1] <= nums[i])
                right++;
            sum += (right - i + 1) * (i - left + 1) * (long) nums[i];
            left = right = i;
            while (left > 0 && nums[left - 1] > nums[i])
                left--;
            while (right < len - 1 && nums[right + 1] >= nums[i])
                right++;
            sum -= (right - i + 1) * (i - left + 1) * (long) nums[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 4, -2, -3, 4, 1 };
        System.out.println(new SumOfSubarrayRanges().subArrayRanges(nums));
    }

}
