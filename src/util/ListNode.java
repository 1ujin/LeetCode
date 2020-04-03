package util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }
    
    @Override
    public String toString() {
        return String.valueOf(val);
    }
    
    public static String toLinkedListString(ListNode node) {
        StringBuilder s = new StringBuilder(node.val);
        while (node.next != null) {
            node = node.next;
            s.append(" -> ");
            s.append(node.val);
        }
        return s.toString();
    }
}
