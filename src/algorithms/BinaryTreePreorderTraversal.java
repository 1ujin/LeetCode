package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class BinaryTreePreorderTraversal {
    
    List<Integer> list = new ArrayList<>();
    
    // method 1 depth-first search
    public List<Integer> preorderTraversal1(TreeNode root) {
        dfs(root);
        return list;
    }

    private void dfs(TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
    
    // method 2 stack
    public List<Integer> preorderTraversal2(TreeNode root) {
        if (root == null) return list;
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.poll().right;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreePreorderTraversal().preorderTraversal1(root));
    }

}
