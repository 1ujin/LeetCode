package lcci;

import java.util.Stack;

import util.Tree;
import util.TreeNode;

public class Binode {

    // method 1 stack
    public TreeNode convertBiNode1(TreeNode root) {
        Stack<TreeNode> deque = new Stack<>();
        TreeNode node = root, pre = new TreeNode(0);
        boolean getRoot = true;
        while (true) {
            if (node != null) {
                deque.push(node);
                node = node.left;
            } else if (!deque.isEmpty()) {
                if (getRoot) {
                    root = deque.peek();
                    getRoot = false;
                }
                node = deque.pop();
                node.left = null;
                pre.right = node;
                pre = node;
                node = node.right;
            } else break;
        }
        return root;
    }
    
    // method 2 recursion
    public TreeNode convertBiNode2(TreeNode root) {
        TreeNode head = new TreeNode(0);
        inOrder(head, root);
        return head.right;
    }

    private TreeNode inOrder(TreeNode pre, TreeNode root) {
        if (root == null) return pre;
        pre = inOrder(pre, root.left);
        root.left = null;
        pre.right = root;
        pre = inOrder(root, root.right);
        return pre;
    }

    public static void main(String[] args) {
        Tree tree = new Tree(new int[] { 4, 2, 6, 1, 3, 5, 7, 0 });
        TreeNode root = new Binode().convertBiNode2(tree.getRoot());
        System.out.println(TreeNode.toTreeString(root));
    }

}
