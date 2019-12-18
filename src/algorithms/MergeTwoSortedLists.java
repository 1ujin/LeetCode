package algorithms;

public class MergeTwoSortedLists {
    
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    // method 1
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode l = null;
        if (l1.val <= l2.val) {
            l = l1;
            l1 = l1.next;
        } else {
            l = l2;
            l2 = l2.next;
        }
        ListNode pointer = l;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pointer.next = l1;
                l1 = l1.next;
            } else {
                pointer.next = l2;
                l2 = l2.next;
            }
            pointer = pointer.next;
        }
        pointer.next = l1 == null ? l2 : l1;
        return l;
    }
    
    // method 2 recursion
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        long startTime = System.nanoTime();
        ListNode l = mergeTwoLists1(l1, l2);
        long endTime = System.nanoTime();
        while (l.next != null) {
            System.out.printf("%d->", l.val);
            l = l.next;
        }
        System.out.println(l.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
