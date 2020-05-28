package algorithms;

public class HouseRobber {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        nums[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++)
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        return nums[len - 1];
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1 };
        System.out.println(new HouseRobber().rob(nums));
    }

}
