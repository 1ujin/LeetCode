package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PancakeSorting {

    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int len = arr.length;
        while (len > 0) {
            int index = 0;
            for (int i = 0; i < len; i++)
                if (arr[i] > arr[index])
                    index = i;
            if (index == --len)
                continue;
            reverse(arr, index);
            reverse(arr, len);
            list.add(index + 1);
            list.add(len + 1);
        }
        return list;
    }

    private void reverse(int[] arr, int end) {
        for (int i = 0, j = end; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 3, 2, 4, 1 };
        System.out.println(new PancakeSorting().pancakeSort(arr));
    }

}
