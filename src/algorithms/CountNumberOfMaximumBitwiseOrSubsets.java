package algorithms;

public class CountNumberOfMaximumBitwiseOrSubsets {

    private int[] nums;
    private int maxOr, cnt;

    public int countMaxOrSubsets(int[] nums) {
        this.nums = nums;
        dfs(0, 0);
        return cnt;
    }

    private void dfs(int pos, int orVal) {
        if (pos == nums.length) {
            if (orVal > maxOr) {
                maxOr = orVal;
                cnt = 1;
            } else if (orVal == maxOr)
                cnt++;
            return;
        }
        dfs(pos + 1, orVal | nums[pos]);
        dfs(pos + 1, orVal);
    }

    public static void main(String[] args) {
        int[] nums = { 3, 2, 1, 5 };
        System.out.println(new CountNumberOfMaximumBitwiseOrSubsets()
                .countMaxOrSubsets(nums));
    }

}
