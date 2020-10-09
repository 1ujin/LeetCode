package algorithms;

import util.List;
import util.ListNode;

public class LinkedListCycle2 {
    
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode node = head;
                while (node != slow) {
                    node = node.next;
                    slow = slow.next;
                }
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] vals = { 3, 2, 0, -4 };
        int pos = 1;
        ListNode head = new List(vals).getHead();
        if (pos > -1) {
            ListNode tail = head, node = head;
            while (tail.next != null)
                tail = tail.next;
            while (pos-- > 0)
                node = node.next;
            tail.next = node;
        }
        System.out.println(new LinkedListCycle2().detectCycle(head));
    }

}
