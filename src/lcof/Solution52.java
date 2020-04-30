package lcof;

public class Solution52 {
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

    public static void main(String[] args) {
        Solution52 solution = new Solution52();
        ListNode headA = solution.new ListNode(4);
        headA.next = solution.new ListNode(1);
        headA.next.next = solution.new ListNode(8);
        headA.next.next.next = solution.new ListNode(4);
        headA.next.next.next.next = solution.new ListNode(5);
        ListNode headB = solution.new ListNode(5);
        headB.next = solution.new ListNode(0);
        headB.next.next = solution.new ListNode(1);
        headB.next.next.next = headA.next.next;
        System.out.println(solution.getIntersectionNode(headA, headB).val);
    }

}
