package lcci;

import java.util.Stack;

public class SortedStack {
    
    private Stack<Integer> stack;
    private Stack<Integer> tmpStack;
    
    public SortedStack() {
        stack = new Stack<>();
        tmpStack = new Stack<>();
    }
    
    public void push(int val) {
        while (!stack.empty() && val > stack.peek())
            tmpStack.push(stack.pop());
        stack.push(val);
        while (!tmpStack.empty())
            stack.push(tmpStack.pop());
    }
    
    public void pop() {
        if (!stack.empty()) stack.pop();
    }
    
    public int peek() {
        return stack.empty() ? -1 : stack.peek();
    }
    
    public boolean isEmpty() {
        return stack.empty();
    }

    public static void main(String[] args) {
        SortedStack obj = new SortedStack();
        obj.push(1);
        obj.push(2);
        System.out.println(obj.peek());
        obj.pop();
        System.out.println(obj.peek());
    }

}
