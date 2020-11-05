package algorithms;

import java.util.Arrays;

public class SortIntegersByTheNumberOf1Bits {
    
    public int[] sortByBits(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
        return arr;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (arr.length < 2 || left >= right) return;
        int lo = left, hi = right, pivot = arr[lo + hi >>> 1],
                bc = Integer.bitCount(pivot);
        while (lo <= hi) {
            while (Integer.bitCount(arr[lo]) < bc
                    || Integer.bitCount(arr[lo]) == bc && arr[lo] < pivot)
                lo++;
            while (Integer.bitCount(arr[hi]) > bc
                    || Integer.bitCount(arr[hi]) == bc && arr[hi] > pivot)
                hi--;
            if (lo < hi) swap(arr, lo++, hi--);
            else if (lo == hi) lo++;
        }
        quickSort(arr, left, hi);
        quickSort(arr, lo, right);
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortIntegersByTheNumberOf1Bits()
                .sortByBits(new int[] { 1, 2, 3, 4, 5, 6, 7, 8 })));
    }

}
