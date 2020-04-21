package sort;

/**
 * <p>平均时间复杂度: O(n^2)
 * <p>最好情况: O(n)
 * <p>最坏情况: O(n^2)
 * <p>额外空间复杂度: O(1)
 * <p>排序方式: In-place
 * <p>稳定性: 稳定
 * <p>描述: (有序区, 无序区)。
 * 把无序区的第一个元素插入到有序区的合适的位置。对数组: 比较得少, 换得多。
 */
public class InsertionSort {
    
    public static void insertionSort(int[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++) {
            int key = a[i];
            int j = i - 1;
            for (; j > -1 && a[j] > key; j--)
                a[j + 1] = a[j];
            a[j + 1] = key;
        }
    }

}
