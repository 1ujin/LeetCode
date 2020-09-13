package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class BinaryTreeInorderTraversal {

    List<Integer> list = new ArrayList<>();
    
    // method 1 depth-first search
    public List<Integer> inorderTraversal1(TreeNode root) {
        inorder(root);
        return list;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    
    // method 2 stack
    public List<Integer> inorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
    
    // method 3 Morris
    public List<Integer> inorderTraversal3(TreeNode root) {
        TreeNode pre = null;
        while (root != null) {
            if (root.left != null) {
                pre = root.left;
                while (pre.right != null && pre.right != root)
                    pre = pre.right;
                if (pre.right == null) {
                    pre.right = root;
                    root = root.left;
                } else {
                    list.add(root.val);
                    pre.right = null;
                    root = root.right;
                }
            } else {
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] vals = { 1, Integer.MIN_VALUE, 2, 3 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreeInorderTraversal().inorderTraversal3(root));
    }

}
