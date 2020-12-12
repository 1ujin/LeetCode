package algorithms;

public class WiggleSubsequence {
    
    // method 1 dynamic programming
    public int wiggleMaxLength1(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int up = 1, down = 1;
        for (int i = 1; i < len; i++) {
            if (nums[i] > nums[i - 1])
                up = Math.max(up, down + 1);
            else if (nums[i] < nums[i - 1])
                down = Math.max(up + 1, down);
        }
        return Math.max(up, down);
    }
    
    // method 2 greedy algorithm
    public int wiggleMaxLength2(int[] nums) {
        int len = nums.length;
        if (len < 2) return len;
        int prevdiff = nums[1] - nums[0];
        int max = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < len; i++) {
            int diff = nums[i] - nums[i - 1];
            if (diff > 0 && prevdiff <= 0 || diff < 0 && prevdiff >= 0) {
                max++;
                prevdiff = diff;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
        System.out.println(new WiggleSubsequence().wiggleMaxLength2(nums));
    }

}
