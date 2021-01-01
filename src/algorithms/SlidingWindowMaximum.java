package algorithms;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if (len < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        Deque<Integer> deque = new LinkedList<>();
        int[] max = new int[len - k + 1];
        // 遍历数组
        for (int i = 0; i < len; i++) {
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[i])
                deque.pollLast();
            // 添加当前值对应的数组下标
            deque.offerLast(i);
            // 判断当前队列中队首的值是否有效
            if (deque.peek() <= i - k)
                deque.pollFirst();   
            // 当窗口长度为k时 保存当前窗口中最大值
            if (i + 1 >= k)
                max[i + 1 - k] = nums[deque.peekFirst()];
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        System.out.println(Arrays.toString(new SlidingWindowMaximum().maxSlidingWindow(nums, 3)));
    }

}
