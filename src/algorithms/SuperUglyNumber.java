package algorithms;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        Set<Long> seen = new HashSet<>();
        Queue<Long> heap = new PriorityQueue<>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int prime : primes) {
                long next = curr * prime;
                if (seen.add(next))
                    heap.offer(next);
            }
        }
        return ugly;
    }

    public static void main(String[] args) {
        int[] primes = { 2, 7, 13, 19 };
        System.out.println(new SuperUglyNumber().nthSuperUglyNumber(12, primes));
    }

}
