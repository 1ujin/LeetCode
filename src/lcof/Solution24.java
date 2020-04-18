package lcof;

import util.List;
import util.ListNode;

public class Solution24 {

    // method 1
    public ListNode reverseList1(ListNode head) {
        ListNode prev = head, next = head.next;
        prev.next = null;
        while (next != null) {
            head = next;
            next = head.next;
            head.next = prev;
            prev = head;
        }
        return head;
    }
    
    // method 2 recursion
    ListNode tail = null;
    
    public ListNode reverseList2(ListNode head) {
        if (head != null)
            recursive(head).next = null;
        return tail;
    }
    
    private ListNode recursive(ListNode node) {
        if (node.next == null) tail = node;
        else recursive(node.next).next = node;
        return node;
    }
    
    // method 3 recursion
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return tail;
    }

    public static void main(String[] args) {
        ListNode head = new List(new int[] { 1, 2, 3, 4, 5 }).getHead();
        System.out.println(ListNode
                .toLinkedListString(new Solution24().reverseList3(head)));
    }

}
