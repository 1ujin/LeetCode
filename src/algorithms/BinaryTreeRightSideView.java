package algorithms;

import java.util.ArrayList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class BinaryTreeRightSideView {
    
    private List<Integer> view;

    public List<Integer> rightSideView(TreeNode root) {
        view = new ArrayList<>();
        dfs(root, 1);
        return view;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) return;
        if (view.size() < level)
            view.add(node.val);
        dfs(node.right, level + 1);
        dfs(node.left, level + 1);
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, Integer.MIN_VALUE, 5, Integer.MIN_VALUE, 4 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreeRightSideView().rightSideView(root));
    }

}
