package algorithms;

import util.List;
import util.ListNode;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode slow = head, fast = head;
        int count = 1;
        while (fast.next != null) {
            fast = fast.next;
            count++;
        }
        k = Math.floorMod(count - k, count);
        if (k == 0) return head;
        while (--k > 0)
            slow = slow.next;
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5 };
        ListNode head = new List(vals).getHead();
        head = new RotateList().rotateRight(head, 6);
        System.out.println(ListNode.toLinkedListString(head));
    }

}
