package algorithms;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] nexts = new int[len];
        Arrays.fill(nexts, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len * 2; i++) {
            int index = i % len;
            while (!stack.isEmpty() && nums[stack.peek()] < nums[index])
                nexts[stack.pop()] = nums[index];
            stack.push(index);
        }
        return nexts;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 1 };
        System.out.println(Arrays.toString(new NextGreaterElement2().nextGreaterElements(nums)));
    }

}
