package algorithms;

public class PopulatingNextRightPointersInEachNode2 {
    
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
        while (begin != null) {
            Node prev = null, next = null;
            for (Node node = begin; node != null; node = node.next) {
                if (node.left != null) {
                    if (prev != null) prev.next = node.left;
                    if (next == null) next = node.left;
                    prev = node.left;
                }
                if (node.right != null) {
                    if (prev != null) prev.next = node.right;
                    if (next == null) next = node.right;
                    prev = node.right;
                }
            }
            begin = next;
        }
        return root;
    }
    
    public static void main(String[] args) {
        
    }

}
