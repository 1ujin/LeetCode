package lcof;

import util.List;
import util.ListNode;

public class SolutionII029 {

    public ListNode insert(ListNode head, int insertVal) {
        ListNode insertNode = new ListNode(insertVal);
        insertNode.next = insertNode;
        if (head == null)
            return insertNode;
        ListNode node = head;
        while (node.next != head) {
            if (node.val <= insertNode.val && node.next.val >= insertNode.val
                    || node.val > node.next.val && (insertNode.val >= node.val
                            || insertNode.val <= node.next.val)) {
                insertNode.next = node.next;
                node.next = insertNode;
                break;
            }
            node = node.next;
        }
        if (insertNode.next == insertNode) {
            insertNode.next = head;
            node.next = insertNode;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = List.of(3, 4, 1).getHead();
        ListNode node = head;
        while (node.next != null)
            node = node.next;
        node.next = head;
        head = new SolutionII029().insert(head, 2);
        System.out.print(head.val);
        for (node = head.next; node != head; node = node.next)
            System.out.print(" -> " + node.val);
    }

}
