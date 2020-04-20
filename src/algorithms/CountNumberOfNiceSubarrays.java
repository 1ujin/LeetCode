package algorithms;

public class CountNumberOfNiceSubarrays {

    public int numberOfSubarrays(int[] nums, int k) {
        int countOdd = 0, len = nums.length;
        for (int i : nums)
            if ((i & 1) == 1)
                countOdd++;
        if (countOdd == 0) return 0;
        int[] odds = new int[countOdd + 2];
        odds[0] = -1;
        odds[countOdd + 1] = len;
        for (int i = 0, j = 1; i < len; i++)
            if ((nums[i] & 1) == 1)
                odds[j++] = i;
        int count = 0;
        for (int i = 1; i <= countOdd - k + 1; i++) {
            int left = odds[i] - odds[i - 1];
            int right = odds[i + k] - odds[i + k - 1];
            count += left * right;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 1, 1 };
        System.out.println(new CountNumberOfNiceSubarrays().numberOfSubarrays(nums, 3));
    }

}
