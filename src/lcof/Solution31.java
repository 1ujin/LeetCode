package lcof;

import java.util.Stack;

public class Solution31 {
    
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int inLen = pushed.length, outLen =  popped.length;
        if (inLen == 0 && outLen == 0) return true;
        int ip = 0, op = 0;
        Stack<Integer> stack = new Stack<>();
        while (ip < inLen || stack.peek().equals(popped[op])) {
            if (ip < inLen)
                stack.push(pushed[ip++]);
            while (!stack.isEmpty() && stack.peek().equals(popped[op])) {
                stack.pop();
                op++;
            }
            if (op == outLen) return true;
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] pushed = { 1, 2, 3, 4, 5 };
        int[] popped = { 4, 3, 5, 2, 1 };
        System.out.println(new Solution31().validateStackSequences(pushed, popped));
    }

}
