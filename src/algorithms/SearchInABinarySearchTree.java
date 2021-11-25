package algorithms;

import util.Tree;
import util.TreeNode;

public class SearchInABinarySearchTree {

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val)
            return root;
        return searchBST(root.val > val ? root.left : root.right, val);
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(4, 2, 7, 1, 3, null).getRoot();
        System.out.println(TreeNode.toTreeString(new SearchInABinarySearchTree().searchBST(root, 2)));
    }

}
