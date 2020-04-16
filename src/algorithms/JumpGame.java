package algorithms;

public class JumpGame {

    public boolean canJump(int[] nums) {
        int last = nums.length - 1;
        for (int i = last; i > -1; i--)
            if (nums[i] + i >= last)
                last = i;
        return last == 0;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(new JumpGame().canJump(nums));
    }

}
