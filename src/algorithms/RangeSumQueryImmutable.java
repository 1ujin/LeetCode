package algorithms;

class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
        for (int i = 1; i < nums.length; i++)
            this.nums[i] += this.nums[i - 1];
    }

    public int sumRange(int i, int j) {
        return nums[j] - (i == 0 ? 0 : nums[i - 1]);
    }

}

public class RangeSumQueryImmutable {

    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2));
        System.out.println(numArray.sumRange(2, 5));
        System.out.println(numArray.sumRange(0, 5));
    }

}
