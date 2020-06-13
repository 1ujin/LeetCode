package algorithms;

import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget {

    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int len = arr.length;
        int[] sums = new int[len + 1];
        for (int i = 1; i <= len; i++)
            sums[i] = sums[i - 1] + arr[i - 1];
        int left = 0, right = arr[len - 1], value = -1;
        while (left <= right) {
            int mid = left + right >> 1, index = Arrays.binarySearch(arr, mid);
            if (index < 0)
                index = -1 - index;
            int sum = sums[index] + (len - index) * mid;
            if (sum <= target)
                left = (value = mid) + 1;
            else right = mid - 1;
        }
        if (value == arr[len - 1]) return value;
        int lowSum = 0, highSum = 0;
        for (int i : arr) {
            lowSum += i < value ? i : value;
            highSum += i < value + 1 ? i : value + 1;
        }
        return target - lowSum <= highSum - target ? value : value + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 3, 5 };
        System.out.println(new SumOfMutatedArrayClosestToTarget().findBestValue(arr, 10));
    }

}
