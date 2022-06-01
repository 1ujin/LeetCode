package algorithms;

import util.Tree;
import util.TreeNode;

public class DeleteNodeInABst {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null)
            return root;
        else if (root.val > key)
            root.left = deleteNode(root.left, key);
        else if (root.val < key)
            root.right = deleteNode(root.right, key);
        else if (root.val == key) {
            if (root.left == root.right)
                return null;
            else if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            TreeNode successor = root.right;
            while (successor.left != null)
                successor = successor.left;
            successor.right = deleteNode(root.right, successor.val);
            successor.left = root.left;
            return successor;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = Tree.of(5, 3, 6, 2, 4, null, 7).getRoot();
        System.out.println(TreeNode.toTreeString(new DeleteNodeInABst()
                .deleteNode(root, 3)));
    }

}
