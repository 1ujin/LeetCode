package lcci;

import java.util.Arrays;

public class SubSort {
    
    public int[] subSort(int[] array) {
        int len = array.length, lo = 0, hi = len - 1;
        if (len == 0) return new int[] {-1, -1};
        while (lo < len - 1 && array[lo] <= array[lo + 1]) lo++;
        if (lo == hi) return new int[] {-1, -1};
        while (hi > 0 && array[hi] >= array[hi - 1]) hi--;
        int[] result = {lo, hi};
        int min = lo, max = hi;
        for (int i = lo; i <= hi; i++) {
            if (array[i] < array[min]) min = i;
            if (array[i] >= array[max]) max = i;
        }
        while (result[0] > -1 && array[result[0]] > array[min]) result[0]--;
        while (result[1] < len && array[result[1]] < array[max]) result[1]++;   
        result[0]++;
        result[1]--;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SubSort().subSort(
                new int[] {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19})));
    }

}
