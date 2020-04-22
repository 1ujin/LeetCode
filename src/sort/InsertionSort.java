package sort;

/**
 * <ul>
 * <li>平均时间复杂度: O(n^2)
 * <li>最好情况: O(n)
 * <li>最坏情况: O(n^2)
 * <li>额外空间复杂度: O(1)
 * <li>排序方式: In-place
 * <li>稳定性: 稳定
 * <li>描述: (有序区, 无序区)。
 * 把无序区的第一个元素插入到有序区的合适的位置。对数组: 比较得少, 换得多。
 * </ul>
 */
public class InsertionSort {
    
    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;
            for (; j > -1 && a[j] > key; j--)
                a[j + 1] = a[j];
            a[j + 1] = key;
        }
    }

}
