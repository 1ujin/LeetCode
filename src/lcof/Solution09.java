package lcof;

import java.util.Stack;

class CQueue {

    Stack<Integer> stack1, stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty())
            return -1;
        int loop = stack1.size();
        if (stack2.size() == 0)
            for (int i = 0; i < loop; i++)
                stack2.push(stack1.pop());
        return stack2.pop();
    }
}

public class Solution09 {

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(1);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(3);
        System.out.println(cQueue.deleteHead());
    }

}
