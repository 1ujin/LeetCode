package algorithms;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class AddTwoNumber {
    
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0), l3;
        l3 = tmp;
        int carry = 0;
        while (true) {
            if (l1.val + l2.val + carry > 9) {
                tmp.val = l1.val + l2.val + carry - 10;
                carry = 1;
            } else {
                tmp.val = l1.val + l2.val + carry;
                carry = 0;
            }
            
            if (l1.next != null || l2.next != null || carry != 0) {
                tmp.next = new ListNode(0);
                tmp = tmp.next;
                
                if (l1.next == null) l1.next = new ListNode(0);
                
                l1 = l1.next;
                
                if (l2.next == null) l2.next = new ListNode(0);
                
                l2 = l2.next;
            } else {
                break;
            }
        }
        return l3;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(6);
        l1.next = new ListNode(0);
        l1.next.next = new ListNode(3);
        
        ListNode l2 = new ListNode(3);
        l2.next = new ListNode(0);
        l2.next.next = new ListNode(8);
        
        long startTime = System.nanoTime();
        ListNode l3 = addTwoNumbers(l1, l2);
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");
        System.out.print(l3.val);
        System.out.print(l3.next.val);
        System.out.print(l3.next.next.val);
    }

}
