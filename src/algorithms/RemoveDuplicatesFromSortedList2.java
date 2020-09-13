package algorithms;

import util.List;
import util.ListNode;

public class RemoveDuplicatesFromSortedList2 {

    // method 1 fastest
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) return head;
        if (head.val == head.next.val) {
            while (head != null && head.next != null && head.val == head.next.val)
                head = head.next;
            return deleteDuplicates1(head.next);
        } else {
            head.next = deleteDuplicates1(head.next);
            return head;
        }
    }
    
    // method 2
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode slow = pre, fast = head;
        while (fast != null && fast.next != null) {
            if (slow.next.val != fast.next.val) {
                slow = slow.next;
                fast = fast.next;
            } else {
                while (fast != null && fast.next != null && fast.val == fast.next.val)
                    fast = fast.next;
                slow.next = fast.next;
                fast = fast.next;
            }
        }
        return pre.next;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 1, 1, 2, 3, 3, 4, 5 };
        ListNode head = new List(vals).getHead();
        head = new RemoveDuplicatesFromSortedList2().deleteDuplicates1(head);
        System.out.println(ListNode.toLinkedListString(head));
    }

}
