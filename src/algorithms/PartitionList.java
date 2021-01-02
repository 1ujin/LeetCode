package algorithms;

import util.List;
import util.ListNode;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode node = new ListNode(-1), preHead = new ListNode(-1);
        ListNode p = preHead, q = node;
        for (; head != null; head = head.next) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
        }
        p.next = node.next;
        q.next = null;
        return preHead.next;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 4, 3, 2, 5, 2 };
        ListNode head = new List(vals).getHead();
        System.out.println(ListNode.toLinkedListString(new PartitionList().partition(head, 3)));
    }

}
