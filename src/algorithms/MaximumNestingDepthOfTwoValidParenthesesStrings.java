package algorithms;

import java.util.Arrays;
import java.util.Stack;

public class MaximumNestingDepthOfTwoValidParenthesesStrings {
    
    // method 1 slow
    public int[] maxDepthAfterSplit1(String seq) {
        int[] answer = new int[seq.length()];
        Stack<Integer> aStack = new Stack<>(), bStack = new Stack<>();
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                if (aStack.size() <= bStack.size()) {
                    aStack.push(i);
                    answer[i] = 0;
                } else {
                    bStack.push(i);
                    answer[i] = 1;
                }
            } else {
                if (aStack.isEmpty()) {
                    answer[i] = 1;
                    bStack.pop();
                } else if (bStack.isEmpty()) {
                    answer[i] = 0;
                    aStack.pop();
                } else if (aStack.peek() > bStack.peek()) {
                    answer[i] = 0;
                    aStack.pop();
                } else {
                    answer[i] = 1;
                    bStack.pop();
                }
            }
        }
        return answer;
    }
    
    // method 2 fastest
    public int[] maxDepthAfterSplit2(String seq) {
        int[] answer = new int[seq.length()];
        int i = -1;
        for (char c : seq.toCharArray())
            answer[++i] = c == '(' ? i & 1 : (i - 1) & 1;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.
                toString(new MaximumNestingDepthOfTwoValidParenthesesStrings().
                maxDepthAfterSplit2("()(())()")));
    }

}
