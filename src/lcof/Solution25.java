package lcof;

import util.List;
import util.ListNode;

public class Solution25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        l2.next = mergeTwoLists(l1, l2.next);
        return l2;
    }

    public static void main(String[] args) {
        ListNode l1 = new List(new int[] { 1, 2, 4 }).getHead();
        ListNode l2 = new List(new int[] { 1, 3, 4 }).getHead();
        System.out.println(ListNode
                .toLinkedListString(new Solution25().mergeTwoLists(l1, l2)));
    }

}
