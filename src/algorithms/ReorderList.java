package algorithms;

import java.util.Deque;
import java.util.LinkedList;

import util.List;
import util.ListNode;

public class ReorderList {
    
    // method 1 double-ended queue
    public void reorderList1(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        for (; head != null; head = head.next)
            deque.offer(head);
        head = deque.pollFirst();
        while (head != null) {
            head.next = deque.pollLast();
            head = head.next;
            if (head == null) break;
            head.next = deque.pollFirst();
            head = head.next;
        }
    }
    
    // method 2 three pointer fastest
    public void reorderList2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast.next != null)
                fast = fast.next;
        }
        if (slow.next == null) return;
        fast = slow.next;
        slow.next = null;
        slow = fast.next;
        fast.next = null;
        while (slow != null) {
            ListNode temp = slow.next;
            slow.next = fast;
            fast = slow;
            slow = temp;
        }
        while (head != null && fast != null) {
            ListNode temp = head.next;
            head.next = fast;
            head = temp;
            temp = fast.next;
            fast.next = head;
            fast = temp;
        }
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5 };
        ListNode head = new List(vals).getHead();
        new ReorderList().reorderList2(head);
        System.out.println(ListNode.toLinkedListString(head));
    }

}
