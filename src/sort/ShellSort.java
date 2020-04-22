package sort;

/**
 * <p>平均时间复杂度: O(nlogn)
 * <p>最好情况: O(nlog^2n)
 * <p>最坏情况: O(n^2)
 * <p>额外空间复杂度: O(1)
 * <p>排序方式: In-place
 * <p>稳定性: 不稳定
 * <p>描述: 每一轮按照事先决定的间隔进行插入排序, 间隔会依次缩小, 最后一定要是 1。
 */
public class ShellSort {
    
    public static void shellSort(int[] a) {
        int len = a.length;
        // Start with a big gap, then reduce the gap
        for (int gap = len >> 1; gap > 0; gap >>= 1) {
            /*
             * Do a gapped insertion sort for this gap size. The first gap
             * elements a[0..gap-1] are already in gapped order keep adding one
             * more element until the entire array is gap sorted
             */
            for (int i = gap; i < len; i++) {
                /*
                 * add a[i] to the elements that have been gap sorted save a[i]
                 * in temp and make a hole at position i
                 */
                int temp = a[i];
                /*
                 * shift earlier gap-sorted elements up until the correct
                 * location for a[i] is found
                 */ 
                int j = i;
                for (; j >= gap && a[j - gap] > temp; j -= gap)
                    a[j] = a[j - gap];
                // put temp (the original a[i]) in its correct location
                a[j] = temp;
            }
        }
    }

}
