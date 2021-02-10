package algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

class KthLargest {

    int k;
    Queue<Integer> queue = new PriorityQueue<>();

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums)
            queue.offer(num);
    }

    public int add(int val) {
        queue.offer(val);
        while (queue.size() > k)
            queue.poll();
        return queue.peek();
    }
}

public class KthLargestElementInAStream {

    public static void main(String[] args) {
        int[] nums = { 4, 5, 8, 2 };
        KthLargest kthLargest = new KthLargest(3, nums);
        System.out.println(kthLargest.add(3)); // return 4
        System.out.println(kthLargest.add(5)); // return 5
        System.out.println(kthLargest.add(10)); // return 5
        System.out.println(kthLargest.add(9)); // return 8
        System.out.println(kthLargest.add(4)); // return 8
    }

}
