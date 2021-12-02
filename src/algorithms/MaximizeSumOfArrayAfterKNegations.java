package algorithms;

public class MaximizeSumOfArrayAfterKNegations {

    public int largestSumAfterKNegations(int[] nums, int k) {
        int[] count = new int[201];
        for (int num : nums)
            count[num + 100]++;
        int index = 0;
        while (k-- > 0) {
            while (count[index] == 0)
                index++;
            count[200 - index]++;
            count[index]--;
            if (index > 100)
                index = 200 - index;
        }
        int sum = 0;
        for (int i = 0; i <= 200; i++)
            sum += count[i] * (i - 100);
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = { 2, -3, -1, 5, -4 };
        System.out.println(new MaximizeSumOfArrayAfterKNegations()
                .largestSumAfterKNegations(nums, 2));
    }

}
