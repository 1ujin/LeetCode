package algorithms;

import java.util.Stack;

public class OneThreeTwoPattern {
    
    public boolean find132pattern(int[] nums) {
        int len = nums.length;
        Stack<Integer> twoStack = new Stack<>();
        int twoMax = Integer.MIN_VALUE;
        twoStack.push(twoMax);
        for (int i = len - 1; i >= 0; i--) {
            int one = nums[i];
            if (one < twoMax)
                return true;
            while (!twoStack.isEmpty() && one > twoStack.peek())
                twoMax = twoStack.pop();
            if (one > twoMax)
                twoStack.push(one);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 3, 2, 0 };
        System.out.println(new OneThreeTwoPattern().find132pattern(nums));
    }

}
