package algorithms;

import util.List;
import util.ListNode;

public class ReverseLinkedList2 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1, head), prev = dummy;
        for (int i = 0; i < left - 1; i++)
            prev = prev.next;
        ListNode node = prev.next, next = node.next;
        for (int i = 0; i < right - left; i++) {
            node.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = node.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5 };
        ListNode head = new List(vals).getHead();
        new ReverseLinkedList2().reverseBetween(head, 2, 4);
        System.out.println(ListNode.toLinkedListString(head));
    }

}
