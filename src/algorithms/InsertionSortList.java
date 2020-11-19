package algorithms;

import util.List;
import util.ListNode;

public class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;
        ListNode node = head;
        while (node.next != null) {
            if (node.val <= node.next.val) {
                node = node.next;
                continue;
            }
            ListNode next = node.next;
            node.next = next.next;
            if (next.val <= head.val) {
                next.next = head;
                head = next;
            } else {
                ListNode prev = head;
                while (prev != node && prev.next.val < next.val)
                    prev = prev.next;
                next.next = prev.next;
                prev.next = next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        int[] vals = { -1, 5, 3, 4, 0 };
        ListNode head = new List(vals).getHead();
        head = new InsertionSortList().insertionSortList(head);
        System.out.println(ListNode.toLinkedListString(head));
    }

}
