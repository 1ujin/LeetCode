package util;

public class List {
    
    private int[] vals;
    private ListNode head;
    
    public List(int[] vals) {
        this.vals = vals;
        if (vals.length == 0) head = null;
        else {
            head = new ListNode(vals[0]);
            ListNode tmp = head;
            for (int i = 1; i < vals.length; i++) {
                tmp.next = new ListNode(vals[i]);
                tmp = tmp.next;
            }
        }
    }

    public int[] getVals() {
        return vals;
    }

    public ListNode getHead() {
        return head;
    }
}
