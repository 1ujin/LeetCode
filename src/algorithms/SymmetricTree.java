package algorithms;

import java.util.LinkedList;
import java.util.Queue;

import util.Tree;
import util.TreeNode;

public class SymmetricTree {

    // method 1 recursion fastest
    public boolean isSymmetric1(TreeNode root) {
        return root == null ? true : recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null || left.val != right.val) return false;
        return recur(left.left, right.right) && recur(left.right, right.left);
    }
    
    // method 2
    public boolean isSymmetric2(TreeNode root) {
        return check(root, root);
    }

    private boolean check(TreeNode p, TreeNode q) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (p == null && q == null) continue;
            if (p == null || q == null || p.val != q.val) return false;
            queue.offer(p.left);
            queue.offer(q.right);
            queue.offer(p.right);
            queue.offer(q.left);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 2, 3, 4, 4, 3 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new SymmetricTree().isSymmetric1(root));
    }

}
