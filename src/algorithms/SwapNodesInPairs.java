package algorithms;

public class SwapNodesInPairs {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode even = odd.next;
        head = head.next;
        while (true) {
            odd.next = even.next;
            even.next = odd;
            if (odd.next != null && odd.next.next != null) {
                even = odd.next.next;
                ListNode newOdd = odd.next;
                odd.next = even;
                odd = newOdd;
            } else break;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        
        long startTime = System.nanoTime();
        ListNode result = swapPairs(head);
        long endTime = System.nanoTime();
        while (result.next != null) {
            System.out.printf("%d->", result.val);
            result = result.next;
        }
        System.out.println(result.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
