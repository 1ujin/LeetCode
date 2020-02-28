package lcci;

public class PalindromeLinkedList {
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    // method 1 backtracking
    ListNode HEAD;
    
    public boolean isPalindrome1(ListNode head) {
        if (head == null) return true;
        HEAD = head;
        return backtrack(head);
    }
    
    private boolean backtrack(ListNode node) {
        if (node.next == null) return node.val == HEAD.val;
        boolean tmp = backtrack(node.next);
        HEAD = HEAD.next;
        return tmp && HEAD.val == node.val;
    }
    
    // method 2 two pointer fastest
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        // find mid node
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse
        slow = slow.next;
        fast = slow.next;
        slow.next = null;
        ListNode tmp = slow;
        while (fast != null) {
            slow = fast;
            fast = fast.next;
            slow.next = tmp;
            tmp = slow;
        }
        // compare
        while (slow != null) {
            if (slow.val != head.val) return false;
            else {
                slow = slow.next;
                head = head.next;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PalindromeLinkedList solution = new PalindromeLinkedList();
        ListNode head = solution.new ListNode(0);
        ListNode rear = head;
        for (int i = 1; i < 1000; i++) {
            rear.next = solution.new ListNode(i);
            rear = rear.next;
        }
        for (int i = 1000; i > -1; i--) {
            rear.next = solution.new ListNode(i);
            rear = rear.next;
        }
        
        long startTime = System.nanoTime();
        boolean result = solution.isPalindrome2(head);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
