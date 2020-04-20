package lcof;

import java.util.Stack;

class MinStack {
    
    private Stack<Integer> stack, minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty() || x <= minStack.peek())
            minStack.push(x);
        stack.push(x);
    }

    public void pop() {
        if (!stack.isEmpty() && minStack.peek().equals(stack.pop()))
            minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}

public class Solution30 {

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min()); // --> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top()); // --> 返回 0.
        System.out.println(minStack.min()); // --> 返回 -2.
    }

}
