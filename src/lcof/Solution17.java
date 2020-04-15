package lcof;

import java.util.Arrays;

public class Solution17 {
    
    public int[] printNumbers(int n) {
        int len = (int) Math.pow(10, n) - 1;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++)
            arr[i] = i + 1;
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution17().printNumbers(1)));
    }

}
