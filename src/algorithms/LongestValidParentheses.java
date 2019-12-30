package algorithms;

import java.util.Stack;

public class LongestValidParentheses {
    
    // method 1 stack
    public static int longestValidParentheses1(String s) {
        if (s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxLen = Math.max(maxLen, i - stack.peek());
                }
            }
        }
        return maxLen;
    }
    
    // method 2 dynamic programming
    public static int longestValidParentheses2(String s) {
        int maxLen = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                // 如果将会产生新的一对闭合括号
                if (s.charAt(i - 1) == '(') {
                    // 累积此闭合括号中已形成的闭合括号子串长度
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                // 如果此闭合括号（不含）中的首个字符在字符串中存在，并且前一个字符是此闭合括号的左括号（能够形成闭合）
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    // 此闭合括号（不含）中的子串长度 + 上一个闭合括号（含）的子串长度 + 此闭合括号（2个字符）的长度
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxLen = Math.max(maxLen, dp[i]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int len = longestValidParentheses2("()(()()");
        long endTime = System.nanoTime();
        System.out.println(len);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
