package algorithms;

import util.List;
import util.ListNode;

public class SplitLinkedListInParts {

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode node = root, prev = new ListNode(0);
        prev.next = root;
        int len = 1;
        while (node != null && node.next != null) {
            len++;
            node = node.next;
        }
        int part = len / k, count = len - part * k, i = 0;
        ListNode[] nodes = new ListNode[k];
        while (i < k && prev.next != null) {
            nodes[i] = prev.next;
            prev.next = null;
            prev = nodes[i++];
            len = part;
            if (count-- > 0)
                len++;
            while (--len > 0 && prev.next != null)
                prev = prev.next;
        }
        return nodes;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        ListNode root = new List(vals).getHead();
        ListNode[] nodes = new SplitLinkedListInParts().splitListToParts(root, 3);
        for (ListNode node : nodes)
            System.out.println(ListNode.toLinkedListString(node));
    }

}
