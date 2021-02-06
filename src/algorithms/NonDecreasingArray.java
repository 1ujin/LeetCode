package algorithms;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        for (int i = 0, count = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1])
                continue;
            if (++count > 1)
                return false;
            if (i > 0 && nums[i + 1] < nums[i - 1])
                nums[i + 1] = nums[i];
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = { 4, 2, 3 };
        System.out.println(new NonDecreasingArray().checkPossibility(nums));
    }

}
