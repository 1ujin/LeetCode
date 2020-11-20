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
    
    public static String toLinkedListString(ListNode head) {
        if (head == null) return null;
        StringBuilder s = new StringBuilder();
        s.append(head.val);
        while (head.next != null) {
            head = head.next;
            s.append(" -> ");
            s.append(head.val);
        }
        return s.toString();
    }
}
