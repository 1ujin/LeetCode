package sort;

import java.util.ArrayList;
import java.util.List;

/**
 * <ul>
 * <li>平均时间复杂度: O(n + k)
 * <li>最好情况: O(n + k)
 * <li>最坏情况: O(n^2)
 * <li>额外空间复杂度: O(n + k)
 * <li>排序方式: Out-place
 * <li>稳定性: 稳定
 * <li>描述: 将值为 i 的元素放入 i 号桶, 最后依次把桶里的元素倒出来。
 * </ul>
 */
public class BucketSort {
    
    private static final int bucketCapacity = 10;
    
    public static void bucketSort(int[] a) {
        // 1) Create n empty buckets
        int min = a[0], max = a[0];
        for (int i : a) {
            if (i > max) max = i;
            if (i < min) min = i;
        }
        int n = (max - min) / bucketCapacity + 1;
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i < n; i++)
            buckets.add(new ArrayList<>());
        // 2) Put array elements in different buckets
        for (int i : a)
            buckets.get((i - min) / 10).add(i);
        int k = 0;
        for (List<Integer> bucket : buckets) {
            // 3) Insertion sort individual buckets
            for (int i = 1; i < bucket.size(); i++) {
                int temp = bucket.get(i);
                int j = i - 1;
                for (; j > -1 && bucket.get(j) > temp; j--)
                    bucket.set(j + 1, bucket.get(j));
                bucket.set(j + 1, temp);
            }
            // 4) Concatenate all buckets into array
            for (int i : bucket)
                a[k++] = i;
        }
    }

}
