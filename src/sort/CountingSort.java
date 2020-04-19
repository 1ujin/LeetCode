package sort;

/**
 * <p>平均时间复杂度: O(n + k)
 * <p>最好情况: O(n + k)
 * <p>最坏情况: O(n + k)
 * <p>额外空间复杂度: O(k)
 * <p>排序方式: Out-place
 * <p>稳定性: 稳定
 * <p>描述: 统计小于等于该元素的个数 i, 于是该元素就放在目标数组的索引 i 位 (i>=0)。
 */
public class CountingSort {
    
    public static void countingSort(int[] a) {
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for (int i : a) {
            if (i > max)
                max = i;
            if (i < min)
                min = i;
        }
        int[] count = new int[max - min + 1];
        for (int i : a)
            count[i - min]++;
        for (int i = 1; i < count.length; i++)
            // 累加值代表 i 这个数在有序数组中的最大下标的后一位
            count[i] += count[i - 1];
        int[] o = new int[a.length];
        for (int i : a)
            // 每遍历一个数，其最大下标就向前移动一位
            o[count[i - min]-- - 1] = i;
        for (int i = 0; i < a.length; i++)
            a[i] = o[i];
    }

}
