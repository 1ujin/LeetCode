package algorithms;

import java.util.Stack;

public class MinStack {
    
    private Stack<Integer> stack;
    private int min;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int x) {
        if (stack.isEmpty())
            min = x;
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == min)
            min = stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

}
