package lcci;

import java.util.Arrays;

public class FindLongestSubarray {

    public String[] findLongestSubarray(String[] array) {
        int len = array.length, diff = 0;
        int[] char0toi = new int[len + 1];
        for (int i = 1; i < char0toi.length; i++) {
            if (array[i - 1].charAt(0) > '9') char0toi[i] = ++diff;
            else char0toi[i] = --diff;
        }
        int[] begins = new int[2 * len + 1];
        Arrays.fill(begins, len);
        for (int i = 0; i < char0toi.length; i++) {
            int index = len + char0toi[i];
            begins[index] = begins[index] < i ? begins[index] : i;
        }
        int max = 0, begin = 0;
        for (int end = len; end > -1; end--) {
            int start = begins[len + char0toi[end]];
            if (end - start >= max) {
                max = end - start;
                begin = start;
            }
        }
        return Arrays.copyOfRange(array, begin, begin + max);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new FindLongestSubarray().findLongestSubarray(new String[] {
                        "A", "1", "B", "C", "D", "2", "3", "4", "E", "5", "F",
                        "G", "6", "7", "H", "I", "J", "K", "L", "M" })));
    }

}
