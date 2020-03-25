package lcof;

import java.util.Arrays;

public class Solution40 {
    
    // method 1
    public int[] getLeastNumbers1(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
    
    // method 2 quick sort fastest
    public int[] getLeastNumbers2(int[] arr, int k) {
        return quickSort(arr, 0, arr.length - 1, k);
    }

    private int[] quickSort(int[] arr, int head, int tail, int k) {
        if (head >= tail || arr == null || arr.length < 2) return arr;
        int pivot = arr[(head + tail) / 2], left = head, right = tail;
        while (left <= right) {
            while (arr[left] < pivot) left++;
            while (arr[right] > pivot) right--;
            if (left < right) swap(arr, left++, right--);
            else if (left == right) left++;
        }
        if (left > k) quickSort(arr, head, right, k);
        else quickSort(arr, left, tail, k);
        return Arrays.copyOf(arr, k);
    }
    
    // method 3 minimum heap sort
    public int[] getLeastNumbers3(int[] arr, int k) {
        return heapSort(arr, k);
    }
    
    private int[] heapSort(int[] arr, int k) {
        int len = arr.length;
        for (int par = (len >> 1) - 1; par > -1; par--)
            minHeapify(arr, par, len);
        for (int fixed = len - 1; fixed >= k; fixed--) {
            swap(arr, 0, fixed);
            minHeapify(arr, 0, fixed);
        }
        return Arrays.copyOf(arr, k);
    }
    
    private void minHeapify(int[] arr, int par, int len) {
        int lc = (par << 1) + 1, rc = lc + 1;
        if (lc >= len) return;
        int maxc = rc < len && arr[lc] < arr[rc] ? rc : lc;
        if (arr[maxc] > arr[par]) {
            swap(arr, maxc, par);
            minHeapify(arr, maxc, len);
        }
    }
    
    // method 4 counting sort
    public int[] getLeastNumbers4(int[] arr, int k) {
        if (k == 0 || arr.length == 0) return new int[0];
        int[] count = new int[10001], result = new int[k];
        for (int i : arr) count[i]++;
        for (int i = 0, j = 0; i < count.length && j < k; i++)
            while (count[i]-- > 0 && j < k)
                result[j++] = i;
        return result;
    }
    
    // common method
    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution40().
                getLeastNumbers4(new int[] {3, 2, 1}, 2)));
    }

}
