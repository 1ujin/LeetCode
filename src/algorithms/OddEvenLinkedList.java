package algorithms;

import util.List;
import util.ListNode;

public class OddEvenLinkedList {
    
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (odd.next != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5 };
        ListNode head = new List(vals).getHead();
        new OddEvenLinkedList().oddEvenList(head);
        System.out.println(ListNode.toLinkedListString(head));
    }

}
