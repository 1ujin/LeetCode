package algorithms;

import java.util.ArrayList;
import java.util.List;

import util.Tree;
import util.TreeNode;

public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        return leaves1.equals(leaves2);
    }

    private void dfs(TreeNode root, List<Integer> leaves) {
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        if (root.left != null)
            dfs(root.left, leaves);
        if (root.right != null)
            dfs(root.right, leaves);
    }

    public static void main(String[] args) {
        int[] vals1 = { 3, 5, 1, 6, 2, 9, 8, -1 << 31, -1 << 31, 7, 4 };
        int[] vals2 = { 3, 5, 1, 6, 7, 4, 2, -1 << 31, -1 << 31, -1 << 31, -1 << 31, -1 << 31, -1 << 31, 9, 8 };
        TreeNode root1 = new Tree(vals1).getRoot();
        TreeNode root2 = new Tree(vals2).getRoot();
        System.out.println(new LeafSimilarTrees().leafSimilar(root1, root2));
    }

}
