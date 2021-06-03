package algorithms;

import util.List;
import util.ListNode;

public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

    public static void main(String[] args) {
        int[] valsA = { 4, 1 }, valsB = { 5, 0, 1 }, valsC = { 8, 4, 5 };
        ListNode headA = new List(valsA).getHead(),
                headB = new List(valsB).getHead(),
                headC = new List(valsC).getHead();
        ListNode nodeA = headA, nodeB = headB;
        while (nodeA.next != null)
            nodeA = nodeA.next;
        while (nodeB.next != null)
            nodeB = nodeB.next;
        nodeA.next = nodeB.next = headC;
        System.out.println(new IntersectionOfTwoLinkedLists()
                .getIntersectionNode(headA, headB).val);
    }

}
