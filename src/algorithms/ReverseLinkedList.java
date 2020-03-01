package algorithms;

public class ReverseLinkedList {
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    // method 1
    public ListNode reverseList1(ListNode head) {
        if (head == null) return head;
        ListNode left = head, right = head.next;
        head.next = null;
        while (right != null) {
            left = right;
            right = right.next;
            left.next = head;
            head = left;
        }
        return head;
    }
    
    // method 2 backtracking
    ListNode rear = null;
    
    public ListNode reverseList2(ListNode head) {
        if (head != null) backtrack(head).next = null;
        return rear;
    }
    
    public ListNode backtrack(ListNode head) {
        if (head.next == null) rear = head;
        else backtrack(head.next).next = head;
        return head;
    }
    
    // method 3 recursion
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rear = reverseList3(head.next);
        head.next.next = head;
        head.next = null;
        return rear;
    }

    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        
        long startTime = System.nanoTime();
        head = solution.reverseList3(head);
        long endTime = System.nanoTime();
        while (head.next != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
        System.out.println(head.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
