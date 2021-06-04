package algorithms;

import util.List;
import util.ListNode;

public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        ListNode prev = new ListNode(-1, head), node = prev;
        while (node.next != null) {
            if (node.next.val == val)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return prev.next;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 6, 3, 4, 5, 6 };
        ListNode head = new List(vals).getHead();
        System.out.println(ListNode.toLinkedListString(
                new RemoveLinkedListElements().removeElements(head, 6)));
    }

}
