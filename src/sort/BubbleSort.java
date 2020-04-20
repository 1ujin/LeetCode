package sort;

/**
 * <p>平均时间复杂度: O(n^2)
 * <p>最好情况: O(n)
 * <p>最坏情况: O(n^2)
 * <p>额外空间复杂度: O(1)
 * <p>排序方式: In-place
 * <p>稳定性: 稳定
 * <p>描述: (无序区, 有序区)。
 * 从无序区通过交换找出最大值放到有序区前端。
 */
public class BubbleSort {
    
    public static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    // swap
                    int max = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = max;
                }
            }
        }
    }
    
    public static void optimizedBubbleSort(int[] a) {
        boolean swapped;
        for (int i = 0; i < a.length - 1; i++) {
            swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    // swap
                    int max = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = max;
                    swapped = true;
                }
            }
            // 如果一次交换都没发生说明顺序已经排好
            if (!swapped)
                break;
        }
    }

}
