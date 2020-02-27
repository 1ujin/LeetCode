package lcci;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNode {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    // method 1 hash table
    public ListNode removeDuplicateNodes1(ListNode head) {
        if (head == null) return head;
        Set<Integer> set = new HashSet<>();
        ListNode tmp = head;
        set.add(head.val);
        while (tmp.next != null) {
            if (!set.add(tmp.next.val)) tmp.next = tmp.next.next;
            else tmp = tmp.next;
        }
        return head;
    }
    
    // method 2 two pointer
    public ListNode removeDuplicateNodes2(ListNode head) {
        if (head == null) return head;
        ListNode left = head, right = head;
        while (right.next != null) {
            while (left != right.next) {
                if (left.val == right.next.val) {
                    right.next = right.next.next;
                    if (right.next == null) return head;
                    left = head;
                } else left = left.next;
            }
            right = right.next;
            left = head;
        }
        return head;
    }

    public static void main(String[] args) {
        RemoveDuplicateNode solution = new RemoveDuplicateNode();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(3);
        head.next.next.next.next = solution.new ListNode(2);
        head.next.next.next.next.next = solution.new ListNode(1);
        
        long startTime = System.nanoTime();
        ListNode result = solution.removeDuplicateNodes2(head);
        long endTime = System.nanoTime();
        while (result.next != null) {
            System.out.printf("%d->", result.val);
            result = result.next;
        }
        System.out.println(result.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
