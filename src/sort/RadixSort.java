package sort;

import java.util.Arrays;

/**
 * <ul>
 * <li>平均时间复杂度: O(n * k)
 * <li>最好情况: O(n * k)
 * <li>最坏情况: O(n * k)
 * <li>额外空间复杂度: O(n + k)
 * <li>排序方式: Out-place
 * <li>稳定性: 稳定
 * <li>描述: 一种多关键字的排序算法, 可用桶排序实现。
 * </ul>
 */
public class RadixSort {
    
    public static void radixSort(int[] a) {
        // Find the maximum number to know number of digits
        int max = a[0], len = a.length;
        for (int i : a)
            max = i > max ? i : max;
        /*
         * Do counting sort for every digit. Note that instead of passing digit
         * number, exponent is passed. Exponent is 10^i where i is current digit
         * number
         */
        int[] output = new int[len], count = new int[10];
        for (int exp = 1; max / exp > 0; exp *= 10) {
            Arrays.fill(count, 0);
            // Store count of occurrences in count[]
            for (int i : a)
                count[i / exp % 10]++;
            /*
             * Change count[i] so that count[i] now contains actual position of
             * this digit in output[]
             */
            for (int i = 1; i < 10; i++)
                count[i] += count[i - 1];
            // Build the output array
            for (int i = len - 1; i > -1; i--)
                output[count[a[i] / exp % 10]-- - 1] = a[i];
            /*
             * Copy the output[] array to a[], so that a[] now contains sorted
             * numbers according to current digit
             */
            for (int i = 0; i < len; i++)
                a[i] = output[i];
        }
    }

}
