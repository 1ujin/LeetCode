package algorithms;

public class FindPivotIndex {

    public int pivotIndex(int[] nums) {
        int leftSum = 0, rightSum = 0;
        for (int num : nums)
            rightSum += num;
        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];
            if (leftSum == rightSum)
                return i;
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        System.out.println(new FindPivotIndex().pivotIndex(nums));
    }

}
