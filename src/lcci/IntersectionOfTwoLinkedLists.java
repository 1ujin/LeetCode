package lcci;

public class IntersectionOfTwoLinkedLists {
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pointerA = headA, pointerB = headB;
        while (pointerA != pointerB) {
            pointerA = pointerA != null ? pointerA.next : headB;
            pointerB = pointerB != null ? pointerB.next : headA;
        }
        return pointerA;
    }

    public static void main(String[] args) {
        IntersectionOfTwoLinkedLists solution = new IntersectionOfTwoLinkedLists();
        ListNode headA = solution.new ListNode(4);
        headA.next = solution.new ListNode(1);
        headA.next.next = solution.new ListNode(8);
        headA.next.next.next = solution.new ListNode(4);
        headA.next.next.next.next = solution.new ListNode(5);
        ListNode headB = solution.new ListNode(5);
        headB.next = solution.new ListNode(0);
        headB.next.next = solution.new ListNode(1);
        headB.next.next.next = headA.next.next;
        
        long startTime = System.nanoTime();
        ListNode result = solution.getIntersectionNode(headA, headB);
        long endTime = System.nanoTime();
        System.out.println(result.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
