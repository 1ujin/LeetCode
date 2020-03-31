package lcof;

import java.util.ArrayList;

import util.ListNode;

public class Solution62 {
    
    // time limit exceeded
    public int lastRemainingLTE(int n, int m) {
        ListNode head = new ListNode(0), tail = head;
        for (int i = 1; i < n; i++) {
            tail.next = new ListNode(i);
            tail = tail.next;
        }
        tail.next = head;
        while (tail.next != tail) {
            int t = m % n;
            for (int i = 1; i < (t == 0 ? n : t); i++)
                tail = tail.next;
            tail.next = tail.next.next;
            n--;
        }
        return tail.val;
    }
    
    // method 1 fastest
    public int lastRemaining1(int n, int m){
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }
    
    // method 2
    public int lastRemaining2(int n, int m) {
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++)
            list.add(i);
        int idx = 0;
        while (n > 1) {
            idx = (idx + m - 1) % n;
            list.remove(idx);
            n--;
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int result = new Solution62().lastRemaining1(56795, 87778);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
