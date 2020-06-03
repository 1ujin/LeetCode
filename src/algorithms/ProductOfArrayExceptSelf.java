package algorithms;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prod1 = new int[len], prod2 = new int[len], output = new int[len];
        prod1[0] = 1;
        prod2[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            prod1[i] = prod1[i - 1] * nums[i - 1];
            prod2[len - 1 - i] = prod2[len - i] * nums[len - i];
        }
        for (int i = 0; i < len; i++)
            output[i] = prod1[i] * prod2[i];
        return output;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(new ProductOfArrayExceptSelf().productExceptSelf(nums)));
    }

}
