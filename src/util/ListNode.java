package util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    @Override
    public String toString() {
        return String.valueOf(val);
    }
    
    public static String toLinkedListString(ListNode node) {
        if (node == null) return null;
        StringBuilder s = new StringBuilder();
        s.append(node.val);
        while (node.next != null) {
            node = node.next;
            s.append(" -> ");
            s.append(node.val);
        }
        return s.toString();
    }
}
