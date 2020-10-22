package algorithms;

import util.List;
import util.ListNode;

public class PalindromeLinkedList {
    
    // method 1 backtracking
    ListNode head;

    public boolean isPalindrome1(ListNode head) {
        this.head = head;
        return backtrack(head);
    }

    private boolean backtrack(ListNode head) {
        if (head == null) return true;
        if (backtrack(head.next) && this.head.val == head.val) {
            this.head = this.head.next;
            return true;
        } else return false;
    }
    
    // method 2 two pointer fastest
    public boolean isPalindrome2(ListNode head) {
        if (head == null) return true;
        ListNode fast = head, slow = head, prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null)
            slow = slow.next;
        while (slow != null && slow.val == prev.val) {
            slow = slow.next;
            prev = prev.next;
        }
        return prev == null;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 2, 1 };
        ListNode head = new List(vals).getHead();
        System.out.println(new PalindromeLinkedList().isPalindrome2(head));
    }

}
