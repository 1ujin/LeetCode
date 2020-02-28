package lcci;

public class SumLists {
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0), head = sum;
        int tmp = 0;
        do {
            tmp += (l1 != null && l2 != null ? (l1.val + l2.val) : (l1 != null ? l1.val : (l2 != null ? l2.val : 0)));
            sum.next = new ListNode(tmp % 10);
            tmp /= 10;
            sum = sum.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        } while (l1 != null || l2 != null || tmp != 0);
        return head.next;
    }

    public static void main(String[] args) {
        SumLists solution = new SumLists();
        ListNode l1 = solution.new ListNode(7);
        l1.next = solution.new ListNode(1);
        l1.next.next = solution.new ListNode(6);
        ListNode l2 = solution.new ListNode(5);
        l2.next = solution.new ListNode(9);
        l2.next.next = solution.new ListNode(2);
        
        long startTime = System.nanoTime();
        ListNode result = solution.addTwoNumbers(l1, l2);
        long endTime = System.nanoTime();
        while (result.next != null) {
            System.out.printf("%d->", result.val);
            result = result.next;
        }
        System.out.println(result.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
