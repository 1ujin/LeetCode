package lcci;

public class KthNodeFromEndOfList {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    // method 1 two pointer
    public int kthToLast1(ListNode head, int k) {
        ListNode left = head, right = head;
        while (right != null) {
            right = right.next;
            if (k > 0) k--;
            else left = left.next;
        }
        return left.val;
    }
    
    // method 2 recursion
    int K = 1;
    
    public int kthToLast2(ListNode head, int k) {
        if (head.next == null) return head.val;
        int val = kthToLast2(head.next, k);
        if (K++ >= k) return val;
        else return head.val;
    }

    public static void main(String[] args) {
        KthNodeFromEndOfList solution = new KthNodeFromEndOfList();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        
        long startTime = System.nanoTime();
        int result = solution.kthToLast2(head, 2);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
