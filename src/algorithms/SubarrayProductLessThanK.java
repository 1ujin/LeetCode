package algorithms;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int num = 0;
        for (int i = 0, j = 0, prod = 1; j < nums.length; j++) {
            prod *= nums[j];
            while (i <= j && prod >= k)
                prod /= nums[i++];
            num += j - i + 1;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 6 };
        System.out.println(new SubarrayProductLessThanK()
                .numSubarrayProductLessThanK(nums, 100));
    }

}
