package algorithms;

import java.util.List;

public class MaximumDepthOfNAryTree {

    @SuppressWarnings("unused")
    private class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    public int maxDepth(Node root) {
        if (root == null)
            return 0;
        int depth = 0;
        for (Node child : root.children)
            depth = Math.max(depth, maxDepth(child));
        return depth + 1;
    }

    public static void main(String[] args) {
        new MaximumDepthOfNAryTree();
    }

}
