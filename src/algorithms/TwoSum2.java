package algorithms;

import java.util.Arrays;

public class TwoSum2 {

    public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;
        for (int i = 0; i < len - 1; i++) {
            int lo = i + 1, hi = len - 1, tmp = target - numbers[i];
            while (lo <= hi) {
                int mid = lo + hi >> 1;
                if (numbers[mid] < tmp)
                    lo = mid + 1;
                else if (numbers[mid] > tmp)
                    hi = mid - 1;
                else return new int[] { i + 1, mid + 1 };
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        System.out.println(Arrays.toString(new TwoSum2().twoSum(numbers, 9)));
    }

}
