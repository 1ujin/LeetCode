package algorithms;

public class PopulatingNextRightPointersInEachNode {
    
    // Definition for a Node.
    @SuppressWarnings("unused")
    private class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    
    public Node connect(Node root) {
        if (root == null) return null;
        Node begin = root;
        while (begin.left != null) {
            Node node = begin;
            while (node != null) {
                node.left.next = node.right;
                if (node.next != null)
                    node.right.next = node.next.left;
                node = node.next;
            }
            begin = begin.left;
        }
        return root;
    }

    public static void main(String[] args) {

    }

}
