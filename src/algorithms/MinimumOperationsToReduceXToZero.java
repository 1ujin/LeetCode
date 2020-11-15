package algorithms;

public class MinimumOperationsToReduceXToZero {
    
    public int minOperations(int[] nums, int x) {
        int total = 0, sum = 0, begin = 0, end = 0, len = -1;
        for (int num : nums)
            total += num;
        // 先将 sum 累加到 total - x 附近，再维护 sum 的值
        while (begin < nums.length) {
            if (end < nums.length)
                sum += nums[end++];
            // 若大于目标则减去最左，直到小于目标
            while (sum > total - x && begin < nums.length)
                sum -= nums[begin++];
            if (sum == total - x)
                len = Math.max(len, end - begin);
            if (end == nums.length)
                begin += 1;
        }
        return len == -1 ? -1 : nums.length - len;
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 20, 1, 1, 3 };
        System.out.println(new MinimumOperationsToReduceXToZero().minOperations(nums, 10));
    }

}
