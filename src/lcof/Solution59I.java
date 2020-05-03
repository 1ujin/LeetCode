package lcof;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution59I {

    // method 1 dequeue
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
        }
        result[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            if (deque.peekFirst() == nums[i - k])
                deque.removeFirst();
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            result[i - k + 1] = deque.peekFirst();
        }
        return result;
    }
    
    // method 2 fastest
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if(nums.length == 0 || k == 0) return new int[0];
        int max = nums[0], maxIdx = 0;
        int[] result = new int[nums.length - k + 1];
        for (int i = 1; i < k; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        result[0] = max;
        for (int i = k; i < nums.length; i++) {
            if (maxIdx > i - k && nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            } else if (maxIdx <= i - k) {
                max = nums[i - k + 1];
                maxIdx = i - k + 1;
                for (int j = i - k + 2; j <= i; j++) {
                    if (nums[j] > max) {
                        max = nums[j];
                        maxIdx = j;
                    }
                }
            }
            result[i - k + 1] = max;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(Arrays.toString(new Solution59I().maxSlidingWindow2(nums, 3)));
    }

}
