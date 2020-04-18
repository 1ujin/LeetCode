package sort;

public class QuickSort {

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }
    
    public static void quickSort(int[] a, int left, int right) {
        if (a.length < 2 || left >= right) return;
        int pivot = a[left + right >>> 1], lo = left, hi = right;
        while (lo <= hi) {
            while (a[lo] < pivot) lo++;
            while (a[hi] > pivot) hi--;
            if (lo < hi) {
                // swap
                int t = a[lo];
                a[lo] = a[hi];
                a[hi] = t;
                lo++; hi--;
            } else if (lo == hi) lo++;
        }
        // divide and conquer
        quickSort(a, left, hi);
        quickSort(a, lo, right);
    }

}
