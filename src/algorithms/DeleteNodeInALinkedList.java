package algorithms;

import util.List;
import util.ListNode;

public class DeleteNodeInALinkedList {

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        int[] vals = { 4, 5, 1, 9 };
        ListNode head = new List(vals).getHead(), node = head.next;
        new DeleteNodeInALinkedList().deleteNode(node);
        System.out.println(ListNode.toLinkedListString(head));
    }

}
