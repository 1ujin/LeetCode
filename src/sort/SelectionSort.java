package sort;

/**
 * <p>平均时间复杂度: O(n^2)
 * <p>最好情况: O(n^2)
 * <p>最坏情况: O(n^2)
 * <p>额外空间复杂度: O(1)
 * <p>排序方式: In-place
 * <p>稳定性: 不稳定
 * <p>描述: (有序区, 无序区)。
 * 在无序区里找一个最小的元素跟在有序区的后面。对数组: 比较得多, 换得少。
 */
public class SelectionSort {
    
    public static void selectionSort(int[] a) {
        int len = a.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
            // find minimum element
            for (int j = i + 1; j < len; j++)
                if (a[minIndex] > a[j])
                    minIndex = j;
            // swap
            if (minIndex != i) {
                int min = a[minIndex];
                a[minIndex] = a[i];
                a[i] = min;
            }
        }
    }

}
