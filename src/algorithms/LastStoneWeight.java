package algorithms;

import java.util.PriorityQueue;
import java.util.Queue;

public class LastStoneWeight {
    
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones)
            queue.offer(stone);
        while (queue.size() > 1)
            queue.offer(Math.abs(queue.poll() - queue.poll()));
        return queue.isEmpty() ? 0 : queue.poll();
    }

    public static void main(String[] args) {
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(new LastStoneWeight().lastStoneWeight(stones));
    }

}
