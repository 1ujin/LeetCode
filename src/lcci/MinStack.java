package lcci;

import java.util.Stack;

public class MinStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> mins;
    
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        mins = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty()) mins.push(x);
        else if (x <= mins.peek()) mins.push(x);
    }
    
    public void pop() {
        if (mins.peek().equals(stack.pop())) mins.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return mins.peek();
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
