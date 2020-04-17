package lcof;

import util.List;
import util.ListNode;

public class Solution22 {
    
    // method 1 two-pointer
    public ListNode getKthFromEnd1(ListNode head, int k) {
        ListNode fast = head, slow = head;
        while (fast != null) {
            fast = fast.next;
            if (k > 0) k--;
            else slow = slow.next;
        }
        return slow;
    }
    
    // method 2 recursion
    int K = 0;
    
    public ListNode getKthFromEnd2(ListNode head, int k) {
        if (head.next == null) return head;
        ListNode node = getKthFromEnd2(head.next, k);
        if (++K >= k) return node;
        else return head;
    }

    public static void main(String[] args) {
        ListNode head = new List(new int[] { 1, 2, 3, 4, 5 }).getHead();
        System.out.println(ListNode
                .toLinkedListString(new Solution22().getKthFromEnd2(head, 2)));
    }

}
