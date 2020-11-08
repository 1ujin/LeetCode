package sort;

/**
 * <p>平均时间复杂度: O(nlogn)
 * <p>最好情况: O(nlogn)
 * <p>最坏情况: O(nlogn)
 * <p>额外空间复杂度: O(1)
 * <p>排序方式: In-place
 * <p>稳定性: 不稳定
 * <p>描述: (最大/小堆, 升/降序区)。
 * 从堆顶把根交换出来放在有序区之前, 再恢复堆。
 */
public class HeapSort {
    
    // Ascending
    public static void ascHeapSort(int[] a) {
        int len = a.length;
        // build maximum heap
        for (int i = len - 1 >>> 1; i > -1; i--)
            maxHeapify(a, i, len);
        // one by one extract the maximum element from heap
        for (int i = len - 1; i > -1; i--) {
            // swap
            int max = a[0];
            a[0] = a[i];
            a[i] = max;
            maxHeapify(a, 0, i);
        }
    }
    
    private static void maxHeapify(int[] a, int parentIndex, int len) {
        int leftIndex = (parentIndex << 1) + 1, rightIndex = leftIndex + 1;
        if (leftIndex >= len) return;
        int maxCihldIndex = leftIndex;
        if (rightIndex < len && a[maxCihldIndex] < a[rightIndex])
            maxCihldIndex = rightIndex;
        if (a[parentIndex] < a[maxCihldIndex]) {
            // swap
            int maxChild = a[maxCihldIndex];
            a[maxCihldIndex] = a[parentIndex];
            a[parentIndex] = maxChild;
            // recursion
            maxHeapify(a, maxCihldIndex, len);
        }
    }

    // Descending
    public static void descHeapSort(int[] a) {
        int len = a.length;
        // build minimum heap
        for (int i = len - 1 >>> 1; i > -1; i--)
            minHeapify(a, i, len);
        // one by one extract the minimum element from heap
        for (int i = len - 1; i > -1; i--) {
            // swap
            int min = a[0];
            a[0] = a[i];
            a[i] = min;
            minHeapify(a, 0, i);
        }
    }
    
    private static void minHeapify(int[] a, int i, int len) {
        int l = (i << 1) + 1, r = l + 1;
        if (l >= len) return;
        int minc = l;
        if (r < len && a[l] > a[r])
            minc = r;
        if (a[i] > a[minc]) {
            // swap
            int min = a[minc];
            a[minc] = a[i];
            a[i] = min;
            // recursion
            minHeapify(a, minc, len);
        }
    }

}
