package algorithms;

import util.List;
import util.ListNode;

public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2 };
        int pos = -1;
        ListNode head = new List(vals).getHead();
        if (pos > -1) {
            ListNode tail = head, node = head;
            while (tail.next != null)
                tail = tail.next;
            while (pos-- > 0)
                node = node.next;
            tail.next = node;
        }
        System.out.println(new LinkedListCycle().hasCycle(head));
    }

}
