package lcci;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    // method 1 hash table
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (set.add(head) && head != null) head = head.next;
        return head;
    }
    
    // method 2 two pointer fastest
    public ListNode detectCycle2(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LinkedListCycle solution = new LinkedListCycle();
        ListNode head = solution.new ListNode(3);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(0);
        head.next.next.next = solution.new ListNode(-4);
        head.next.next.next.next = head.next;
        
        long startTime = System.nanoTime();
        ListNode result = solution.detectCycle2(head);
        long endTime = System.nanoTime();
        System.out.println(result.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
