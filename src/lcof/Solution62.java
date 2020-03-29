package lcof;

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
    
    public int lastRemaining(int n, int m){
        int last = 0;
        for (int i = 2; i <= n; i++)
            last = (last + m) % i;
        return last;
    }

    public static void main(String[] args) {
        System.out.println(new Solution62().lastRemaining(56795, 87778));
    }

}
