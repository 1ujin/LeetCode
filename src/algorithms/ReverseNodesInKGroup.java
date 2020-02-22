package algorithms;

public class ReverseNodesInKGroup {
    
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    private static ListNode getNode(ListNode srcNode, int k) {
        ListNode destNode = srcNode;
        for (; k > 0 && destNode != null; k--)
            destNode = destNode.next;
        return destNode;
    }
    
    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode retNode = getNode(head, k - 1);
        if (retNode == null || k <= 1) return head;
        ListNode rear = getNode(head, k - 1);
        ListNode nextHead = rear.next;
        for (int i = k - 2; i >= 0; i--) {
            rear.next = getNode(head, i);
            rear = rear.next;
        }
        head.next = reverseKGroup(nextHead, k);
        return retNode;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        long startTime = System.nanoTime();
        ListNode result = reverseKGroup(head, 3);
        long endTime = System.nanoTime();
        while (result.next != null) {
            System.out.printf("%d->", result.val);
            result = result.next;
        }
        System.out.println(result.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
