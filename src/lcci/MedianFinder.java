package lcci;

import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder {
    
    private Queue<Integer> minHeap, maxHeap;
    
    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        if (maxHeap.size() != 0 && num > maxHeap.peek())
            minHeap.offer(num);
        else
            maxHeap.offer(num);
        while (maxHeap.size() < minHeap.size())
            maxHeap.offer(minHeap.poll());
        while (maxHeap.size() > minHeap.size() + 1)
            minHeap.offer(maxHeap.poll());
    }
    
    public double findMedian() {
        if (minHeap.size() + maxHeap.size() == 0)
            return -1;
        if ((minHeap.size() + maxHeap.size() & 1) == 1)
            return maxHeap.peek();
        return (double) (maxHeap.peek() + minHeap.peek()) / 2;
    }

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
    }

}
