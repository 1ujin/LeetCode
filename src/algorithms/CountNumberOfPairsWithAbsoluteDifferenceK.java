package algorithms;

public class CountNumberOfPairsWithAbsoluteDifferenceK {

    public int countKDifference(int[] nums, int k) {
        int[] counts = new int[101];
        for (int num : nums)
            counts[num]++;
        int sum = 0;
        for (int i = 1; i < 101 - k; i++)
            sum += counts[i] * counts[i + k];
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 1 };
        System.out.println(new CountNumberOfPairsWithAbsoluteDifferenceK()
                .countKDifference(nums, 1));
    }

}
