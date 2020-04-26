package lcof;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    
    Queue<Integer> firstHalf, secondHalf;

    /** initialize your data structure here. */
    public MedianFinder() {
        firstHalf = new PriorityQueue<>((a, b) -> b - a);
        secondHalf = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if (firstHalf.isEmpty())
            firstHalf.offer(num);
        else if (firstHalf.size() == secondHalf.size()) {
            if (secondHalf.peek() < num) {
                firstHalf.offer(secondHalf.poll());
                secondHalf.offer(num);
            } else firstHalf.offer(num);
        } else {
            if (firstHalf.peek() > num) {
                secondHalf.offer(firstHalf.poll());
                firstHalf.offer(num);
            } else secondHalf.offer(num);
        }
    }
    
    public double findMedian() {
        if ((firstHalf.size() + secondHalf.size() & 1) == 1)
            return (double) firstHalf.peek();
        return ((double) firstHalf.peek() + (double) secondHalf.peek()) / 2;
    }
}

public class Solution41 {
    
    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(1);
        mf.addNum(2);
        System.out.println(mf.findMedian());
        mf.addNum(3);
        System.out.println(mf.findMedian());
    }

}
