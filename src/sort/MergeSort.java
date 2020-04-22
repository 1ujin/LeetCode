package sort;

/**
 * <p>平均时间复杂度: O(nlogn)
 * <p>最好情况: O(nlogn)
 * <p>最坏情况: O(nlogn)
 * <p>额外空间复杂度: 从下到上O(1), 从上到下O(n)
 * <p>排序方式: Out-place
 * <p>稳定性: 稳定
 * <p>描述: 把数据分为两段, 从两段中逐个选最小的元素移入新数据的末尾。
 * 可从上到下或从下到上进行。
 */
public class MergeSort {
    
    /**
     * 迭代法 (Bottom-up)
     * <ul>
     * <li>1.将序列每相邻两个数字进行归并操作, 形成{@code ceil(n/2)}个序列, 排序后每个序列包含两/一个元素
     * <li>2.若此时序列数不是1个则将上述序列再次归并, 形成{@code ceil(n/4)}个序列, 每个序列包含四/三个元素
     * <li>3.重复步骤2, 直到所有元素排序完毕, 即序列数为1
     * </ul>
     */
    public static void mergeSort(int[] a) {
        int len = a.length;
        int[] ordered = new int[len];
        for (int i = 2; i < len << 1; i <<= 1) {
            for (int j = 0; j < (len + i - 1) / i; j++) {
                int begin = i * j;
                int end = begin + i - 1 < len ? begin + i - 1 : len - 1;
                int mid = begin + end >> 1;
                int begin1 = begin, end1 = mid, begin2 = mid + 1, end2 = end;
                int k = begin;
                while (begin1 <= end1 && begin2 <= end2)
                    ordered[k++] = a[begin1] < a[begin2] ? a[begin1++] : a[begin2++];
                while (begin1 <= end1)
                    ordered[k++] = a[begin1++];
                while (begin2 <= end2)
                    ordered[k++] = a[begin2++];
                System.arraycopy(ordered, begin, a, begin, end - begin + 1);
            }
        }
    }
    
    /**
     * 递归法 (Top-down)
     * <ul>
     * <li>1.申请空间, 使其大小为两个已经排序序列之和，该空间用来存放合并后的序列
     * <li>2.设定两个指针, 最初位置分别为两个已经排序序列的起始位置
     * <li>3.比较两个指针所指向的元素, 选择相对小的元素放入到合并空间, 并移动指针到下一位置
     * <li>4.重复步骤3直到某一指针到达序列尾
     * <li>5.将另一序列剩下的所有元素直接复制到合并序列尾
     * </ul>
     */
    public static void recurMergeSort(int[] a) {
        int len = a.length;
        int[] ordered = new int[len];
        recur(a, ordered, 0, len - 1);
    }

    static void recur(int[] a, int[] ordered, int begin, int end) {
        if (begin >= end) return;
        int mid = (end - begin >> 1) + begin;
        int begin1 = begin, end1 = mid, begin2 = mid + 1, end2 = end;
        recur(a, ordered, begin1, end1);
        recur(a, ordered, begin2, end2);
        int i = begin;
        while (begin1 <= end1 && begin2 <= end2)
            ordered[i++] = a[begin1] < a[begin2] ? a[begin1++] : a[begin2++];
        while (begin1 <= end1)
            ordered[i++] = a[begin1++];
        while (begin2 <= end2)
            ordered[i++] = a[begin2++];
        for (i = begin; i <= end; i++)
            a[i] = ordered[i];
    }

}
