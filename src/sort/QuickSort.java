package sort;

/**
 * <p>平均时间复杂度: O(nlogn)
 * <p>最好情况: O(nlogn)
 * <p>最坏情况: O(n^2)
 * <p>额外空间复杂度: O(logn)
 * <p>排序方式: In-place
 * <p>稳定性: 不稳定
 * <p>描述: (小数, 基准元素, 大数)。
 * 在区间中间挑选一个元素作基准, 将小于基准的元素放在基准之前, 
 * 大于基准的元素放在基准之后, 再分别对小数区与大数区进行排序(分治)。
 */
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
