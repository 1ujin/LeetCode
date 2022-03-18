package algorithms;

import util.Tree;
import util.TreeNode;

public class ConstructStringFromBinaryTree {

    public String tree2str(TreeNode root) {
        if (root == null)
            return "";
        if (root.left == null && root.right == null)
            return String.valueOf(root.val);
        if (root.right == null)
            return new StringBuilder().append(root.val).append("(")
                    .append(tree2str(root.left)).append(")").toString();
        return new StringBuilder().append(root.val).append("(")
                .append(tree2str(root.left)).append(")").append("(")
                .append(tree2str(root.right)).append(")").toString();
    }

    public static void main(String[] args) {
        TreeNode root = new Tree(1, 2, 3, null, 4).getRoot();
        System.out.println(new ConstructStringFromBinaryTree().tree2str(root));
    }

}
