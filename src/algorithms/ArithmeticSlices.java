package algorithms;

public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 2)
            return 0;
        int d = nums[0] - nums[1], t = 0, count = 0;
        for (int i = 2; i < len; i++) {
            if (nums[i - 1] - nums[i] == d)
                t++;
            else {
                d = nums[i - 1] - nums[i];
                t = 0;
            }
            count += t;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 7, 9 };
        System.out.println(new ArithmeticSlices().numberOfArithmeticSlices(nums));
    }

}
