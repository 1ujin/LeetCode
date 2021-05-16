package algorithms;

import java.util.LinkedList;
import java.util.Queue;

import util.Tree;
import util.TreeNode;

public class CousinsInBinaryTree {

    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Queue<TreeNode> childs = new LinkedList<>();
            for (TreeNode parent : queue) {
                int left = -1, right = -1;
                if (parent.left != null) {
                    childs.offer(parent.left);
                    left = parent.left.val;
                }
                if (parent.right != null) {
                    childs.offer(parent.right);
                    right = parent.right.val;
                }
                if (left == x && right == y || left == y && right == x)
                    return false;
            }
            for (TreeNode xNode : childs)
                if (xNode.val == x)
                    for (TreeNode yNode : childs)
                        if (yNode.val == y)
                            return true;
            queue = childs;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, -1 << 31, 4, -1 << 31, 5 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new CousinsInBinaryTree().isCousins(root, 5, 4));
    }

}
