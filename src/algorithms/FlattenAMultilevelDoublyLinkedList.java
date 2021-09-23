package algorithms;

public class FlattenAMultilevelDoublyLinkedList {

    @SuppressWarnings("unused")
    private class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    }

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    private Node dfs(Node head) {
        if (head == null)
            return null;
        while (head.next != null || head.child != null) {
            Node next = head.next, lastChild = dfs(head.child);
            if (lastChild != null) {
                head.child.prev = head;
                head.next = head.child;
                head.child = null;
            }
            if (lastChild != null && next != null) {
                lastChild.next = next;
                next.prev = lastChild;
            }
            if (next != null) {
                head = next;
            }
        }
        return head;
    }
    
    public static void main(String[] args) {
        
    }

}
