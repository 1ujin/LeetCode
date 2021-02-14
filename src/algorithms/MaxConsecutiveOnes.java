package algorithms;

public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, left = 0, right = 0;
        while (left < nums.length) {
            while (left < nums.length && nums[left] == 0)
                left++;
            right = left;
            while (right < nums.length && nums[right] == 1)
                right++;
            max = Math.max(max, right - left);
            left = right + 1;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        System.out.println(new MaxConsecutiveOnes().findMaxConsecutiveOnes(nums));
    }

}
