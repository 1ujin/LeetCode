package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class BinaryTreePostorderTraversal {
    
    List<Integer> list = new ArrayList<>();
    
    // method 1 depth-first search
    public List<Integer> postorderTraversal1(TreeNode root) {
        postorder(root);
        return list;
    }
    
    private void postorder(TreeNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        list.add(root.val);
    }

    // method 2 stack
    public List<Integer> postorderTraversal2(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null;
        while (root != null || !stack.isEmpty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.poll();
            if (root.right == null || root.right == pre) {
                list.add(root.val);
                pre = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return list;
    }
    
    // method 3 Morris
    public List<Integer> postorderTraversal3(TreeNode root) {
        TreeNode p1 = root, p2 = null;
        while (p1 != null) {
            p2 = p1.left;
            if (p2 != null) {
                while (p2.right != null && p2.right != p1)
                    p2 = p2.right;
                if (p2.right == null) {
                    p2.right = p1;
                    p1 = p1.left;
                    continue;
                } else {
                    p2.right = null;
                    addPath(list, p1.left);
                }
            }
            p1 = p1.right;
        }
        addPath(list, root);
        return list;
    }

    private void addPath(List<Integer> list, TreeNode node) {
        List<Integer> tmp = new ArrayList<Integer>();
        while (node != null) {
            tmp.add(node.val);
            node = node.right;
        }
        for (int i = tmp.size() - 1; i >= 0; i--)
            list.add(tmp.get(i));
    }

    public static void main(String[] args) {
        int[] vals = { 1, 1 << 31, 2, 3 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreePostorderTraversal().postorderTraversal3(root));
    }

}
