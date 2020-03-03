package lcci;

import java.util.Stack;

public class ImplementQueueUsingStacks {
    
    private boolean reverse;
    private Stack<Integer> stack;
    private Stack<Integer> reverseStack;

    /** Initialize your data structure here. */
    public ImplementQueueUsingStacks() {
        reverse = false;
        stack = new Stack<>();
        reverseStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        if (reverse)
            while (!reverseStack.empty())
                stack.push(reverseStack.pop());
        reverse = false;
        stack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (!reverse)
            while (!stack.empty())
                reverseStack.push(stack.pop());
        reverse = true;
        int ret = reverseStack.pop();
        return ret;
    }
    
    /** Get the front element. */
    public int peek() {
        if (!reverse)
            while (!stack.empty())
                reverseStack.push(stack.pop());
        reverse = true;
        int ret = reverseStack.peek();
        return ret;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty() && reverseStack.empty();
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks queue = new ImplementQueueUsingStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}
