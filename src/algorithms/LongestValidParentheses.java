package algorithms;

import java.util.Stack;

public class LongestValidParentheses {
    
    public static int longestValidParentheses(String s) {
        if (s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    count = Math.max(count, i - stack.peek());
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int len = longestValidParentheses(")");
        long endTime = System.nanoTime();
        System.out.println(len);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
