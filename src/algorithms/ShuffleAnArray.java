package algorithms;

import java.util.Arrays;
import java.util.Random;

public class ShuffleAnArray {

    private int[] nums, rand;

    public ShuffleAnArray(int[] nums) {
        this.nums = nums;
        rand = nums.clone();
    }

    public int[] reset() {
        return nums;
    }

    public int[] shuffle() {
        Random random = new Random();
        for (int i = 0; i < rand.length; i++) {
            int j = i + random.nextInt(rand.length - i);
            int tmp = rand[i];
            rand[i] = rand[j];
            rand[j] = tmp;
        }
        return rand;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        ShuffleAnArray shuffle = new ShuffleAnArray(nums);
        System.out.println(Arrays.toString(shuffle.shuffle())); // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
        System.out.println(Arrays.toString(shuffle.reset())); // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
        System.out.println(Arrays.toString(shuffle.shuffle())); // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
    }

}
