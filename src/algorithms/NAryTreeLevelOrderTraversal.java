package algorithms;

import java.util.ArrayList;
import java.util.List;

public class NAryTreeLevelOrderTraversal {
    
    @SuppressWarnings("unused")
    private static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    
    public List<List<Integer>> levelOrder(Node root) {
        List<Node> nodes = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        if (root != null)
            nodes.add(root);
        while (!nodes.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<Node> tmp = new ArrayList<>();
            for (Node node : nodes) {
                list.add(node.val);
                tmp.addAll(node.children);
            }
            nodes = tmp;
            lists.add(list);
        }
        return lists;
    }

    public static void main(String[] args) {

    }

}
