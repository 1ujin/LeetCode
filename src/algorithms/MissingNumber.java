package algorithms;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i <= nums.length; i++)
            xor ^= i;
        for (int num : nums)
            xor ^= num;
        return xor;
    }

    public static void main(String[] args) {
        int[] nums = { 9, 6, 4, 2, 3, 5, 7, 0, 1 };
        System.out.println(new MissingNumber().missingNumber(nums));
    }

}
