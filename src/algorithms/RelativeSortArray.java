package algorithms;

import java.util.Arrays;

public class RelativeSortArray {
    
    // method 1 quick sort
    int[] arr1, arr2;

    public int[] relativeSortArray1(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
        quickSort(0, arr1.length - 1);
        return arr1;
    }

    private void quickSort(int left, int right) {
        if (arr1.length < 2 || left >= right) return;
        int lo = left, hi = right, mid = arr1[lo + hi >> 1], pivot = findArr2(mid);
        while (lo <= hi) {
            while (findArr2(arr1[lo]) < pivot || findArr2(arr1[lo]) == pivot && arr1[lo] < mid) lo++;
            while (findArr2(arr1[hi]) > pivot || findArr2(arr1[hi]) == pivot && arr1[hi] > mid) hi--;
            if (lo < hi) swap(lo++, hi--);
            else if (lo == hi) lo++;
        }
        quickSort(left, hi);
        quickSort(lo, right);
    }

    private int findArr2(int num) {
        for (int i = 0; i < arr2.length; i++)
            if (num == arr2[i])
                return i;
        return 0x7fffffff;
    }

    private void swap(int i, int j) {
        int t = arr1[i];
        arr1[i] = arr1[j];
        arr1[j] = t;
    }
    
    // method 2 counting sort fastest
    public int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] count = new int[1001], arr = new int[arr1.length];
        for (int i : arr1)
            count[i]++;
        int index = 0;
        for (int i : arr2)
            while (count[i]-- > 0)
                arr[index++] = i;
        for (int i = 0; i < 1001; i++)
            while (count[i]-- > 0)
                arr[index++] = i;
        return arr;
    }

    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        int[] arr2 = { 2, 1, 4, 3, 9, 6 };
        System.out.println(Arrays.toString(new RelativeSortArray()
                .relativeSortArray2(arr1, arr2)));
    }

}
