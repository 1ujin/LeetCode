package lcci;

import java.util.Arrays;

public class SmallestK {
    
    // method 1 quick sort
    public int[] smallestK1(int[] arr, int k) {
        return quickSort(arr, 0, arr.length - 1, k);
    }

    private int[] quickSort(int[] arr, int left, int right, int k) {
        if (left == right || arr.length < 2) return arr;
        int lo = left, hi = right, pivot = arr[left + right >>> 1];
        while (lo <= hi) {
            while (arr[lo] < pivot) lo++;
            while (arr[hi] > pivot) hi--;
            if (lo < hi) swap(arr, lo++, hi--);
            else if (lo == hi) lo++;
        }
        if (hi >= k) quickSort(arr, left, hi, k);
        else quickSort(arr, lo, right, k);
        return Arrays.copyOf(arr, k);
    }
    
    // method 2 minimum heap sort
    public int[] smallestK2(int[] arr, int k) {
        int len = arr.length;
        for (int i = (len >>> 1) - 1; i > -1; i--)
            minHeapify(arr, i, len);
        for (int i = len - 1; i > k - 1; i--) {
            swap(arr, 0, i);
            minHeapify(arr, 0, i);
        }
        return Arrays.copyOf(arr, k);
    }
    
    private void minHeapify(int[] arr, int i, int len) {
        int l = (i << 1) + 1, r = l + 1;
        if (l >= len) return;
        int max = r < len ? (arr[l] > arr[r] ? l : r) : l;
        if (arr[i] < arr[max]) {
            swap(arr, i, max);
            minHeapify(arr, max, len);
        }
    }

    // common method
    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SmallestK()
                .smallestK2(new int[] { 1, 3, 5, 7, 2, 4, 6, 8 }, 4)));
    }

}
