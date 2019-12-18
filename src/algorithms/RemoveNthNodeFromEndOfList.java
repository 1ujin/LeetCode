package algorithms;

public class RemoveNthNodeFromEndOfList {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode pointer = head, nthPreNode = head;
        while (true) {
            if (pointer.next == null) {
                if (n == 1) {
                    head = head.next;
                    return head;
                }
                nthPreNode.next = nthPreNode.next.next;
                break;
            }
            if (n == 0) nthPreNode = nthPreNode.next;
            else n--;
            pointer = pointer.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        long startTime = System.nanoTime();
        removeNthFromEnd(head, 2);
        long endTime = System.nanoTime();
        System.out.println(head.next.next.next.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
