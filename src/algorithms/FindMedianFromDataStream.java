package algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {

    private Queue<Integer> minQueue, maxQueue;

    /** initialize your data structure here. */
    public MedianFinder() {
        minQueue = new PriorityQueue<>((a, b) -> b - a);
        maxQueue = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (minQueue.isEmpty() || num < minQueue.peek()) {
            minQueue.offer(num);
            if (minQueue.size() > maxQueue.size() + 1)
                maxQueue.offer(minQueue.poll());
        } else {
            maxQueue.offer(num);
            if (maxQueue.size() > minQueue.size())
                minQueue.offer(maxQueue.poll());
        }
    }

    public double findMedian() {
        if (minQueue.size() > maxQueue.size())
            return minQueue.peek();
        return (minQueue.peek() + maxQueue.peek()) / 2.0;
    }

}

public class FindMedianFromDataStream {

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }

}
