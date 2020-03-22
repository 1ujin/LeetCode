package algorithms;

import util.List;
import util.ListNode;

public class MiddleOfTheLinkedList {
    
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println(new MiddleOfTheLinkedList().middleNode(new List(new int[] {1, 2, 3, 4, 5}).getHead()).val);
    }

}
