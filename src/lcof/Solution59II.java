package lcof;

import java.util.LinkedList;
import java.util.Queue;

public class Solution59II {
    
    private Queue<Integer> queue;
    private LinkedList<Integer> deque;

    public Solution59II() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }
    
    public int max_value() {
        if (deque.isEmpty()) return -1;
        return deque.peekFirst();
    }
    
    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && value > deque.peekLast()) deque.pollLast();
        deque.offerLast(value);
    }
    
    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (queue.peek().equals(deque.peekFirst())) deque.pollFirst();
        return queue.poll();
    }

    public static void main(String[] args) {
        Solution59II obj = new Solution59II();
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
        obj.push_back(46);
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
        System.out.println(obj.pop_front());
        obj.push_back(868);
        System.out.println(obj.pop_front());
        System.out.println(obj.pop_front());
        System.out.println(obj.pop_front());
        obj.push_back(525);
        System.out.println(obj.pop_front());
        System.out.println(obj.max_value());
    }

}
