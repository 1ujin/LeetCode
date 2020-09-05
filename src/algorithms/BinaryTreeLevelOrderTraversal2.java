package algorithms;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class BinaryTreeLevelOrderTraversal2 {

    // method 1 breadth-first search
    public List<List<Integer>> levelOrderBottom1(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Deque<List<Integer>> deque = new LinkedList<>();
        List<TreeNode> level = new ArrayList<>();
        level.add(root);
        while (!level.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            List<TreeNode> tmp = new ArrayList<>();
            for (TreeNode node : level) {
                if (node != null)
                    list.add(node.val);
                if (node.left != null)
                    tmp.add(node.left);
                if (node.right != null)
                    tmp.add(node.right);
            }
            deque.addFirst(list);
            level = tmp;
        }
        return new ArrayList<>(deque);
    }
    
    // method 2 depth-first search fastest
    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>(), result = new ArrayList<>();
        dfs(root, 0, list);
        for (int i = list.size() - 1; i >= 0; i--)
            result.add(list.get(i));
        return result;
    }

    private void dfs(TreeNode root, int depth, List<List<Integer>> list) {
        if (root == null) return;
        if (list.size() <= depth)
            list.add(new ArrayList<>());
        dfs(root.left, depth + 1, list);
        dfs(root.right, depth + 1, list);
        list.get(depth).add(root.val);
    }

    public static void main(String[] args) {
        int[] vals = { 3, 9, 20, Integer.MIN_VALUE, Integer.MIN_VALUE, 15, 7 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreeLevelOrderTraversal2().levelOrderBottom2(root));
    }

}
