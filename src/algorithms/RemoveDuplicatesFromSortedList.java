package algorithms;

import util.List;
import util.ListNode;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode node = head;
        while (node != null && node.next != null) {
            if (node.val == node.next.val)
                node.next = node.next.next;
            else node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 1, 2, 3, 3 };
        ListNode head = new List(vals).getHead();
        new RemoveDuplicatesFromSortedList().deleteDuplicates(head);
        System.out.println(ListNode.toLinkedListString(head));
    }

}
