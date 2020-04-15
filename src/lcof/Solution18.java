package lcof;

import util.List;
import util.ListNode;

public class Solution18 {

    public ListNode deleteNode(ListNode head, int val) {
        if (head == null)
            return null;
        if (head.val == val)
            return head.next;
        ListNode node = head;
        while (node.next != null && node.next.val != val)
            node = node.next;
        if (node.next != null && node.next.val == val)
            node.next = node.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new List(new int[] { 4, 5, 1, 9 }).getHead();
        head = new Solution18().deleteNode(head, 5);
        System.out.println(ListNode.toLinkedListString(head));
    }

}
