package lcof;

import util.Tree;
import util.TreeNode;

public class Solution36 {
    
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return null;
        TreeNode[] nodes = dfs(root);
        nodes[0].left = nodes[1];
        nodes[1].right = nodes[0];
        return nodes[0];
    }
    
    private TreeNode[] dfs(TreeNode root) {
        TreeNode left = root, right = root;
        if (root.left != null) {
            TreeNode[] prev = dfs(root.left);
            prev[1].right = root;
            root.left = prev[1];
            left = prev[0];
        }
        if (root.right != null) {
            TreeNode[] next = dfs(root.right);
            next[0].left = root;
            root.right = next[0];
            right = next[1];
        }
        return new TreeNode[] { left, right };
    }

    public static void main(String[] args) {
        int[] vals = { 4, 2, 5, 1, 3 };
        TreeNode root = new Tree(vals).getRoot();
        TreeNode head = new Solution36().treeToDoublyList(root);
        for (int i = 0; i <= vals.length; i++) {
            System.out.print(head.val);
            head = head.right;
        }
    }

}
