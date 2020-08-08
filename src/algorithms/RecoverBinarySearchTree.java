package algorithms;

import util.Tree;
import util.TreeNode;

public class RecoverBinarySearchTree {
    
    // method 1
    int count = 0;

    public void recoverTree1(TreeNode root) {
        count(root);
        while (count > 0) {
            inorder(root, count);
            count--;
        }
    }

    private void count(TreeNode root) {
        if (root == null) return;
        count++;
        count(root.left);
        count(root.right);
    }
    
    private void inorder(TreeNode root, int count) {
        if (root == null || root.left == null && root.right == null || count-- < -1) return;
        TreeNode leftMax = root.left, rightMin = root.right;
        inorder(root.left, count);
        while (leftMax != null && leftMax.right != null)
            leftMax = leftMax.right;
        while (rightMin != null && rightMin.left != null)
            rightMin = rightMin.left;
        sort(leftMax, root, rightMin);
        inorder(root.right, count);
    }
    
    private void sort(TreeNode a, TreeNode b, TreeNode c) {
        if (a != null && a.val > b.val)
            swap(a, b);
        if (c != null && b.val > c.val)
            swap(b, c);
        if (a != null && c != null && a.val > c.val)
            swap(a, c);
    }

    private void swap(TreeNode p, TreeNode q) {
        int val = p.val;
        p.val = q.val;
        q.val = val;
    }
    
    //method 2 有且仅有两个节点错位时
    TreeNode firstNode, secondNode, preNode = new TreeNode(Integer.MIN_VALUE);
    
    public void recoverTree2(TreeNode root) {
        inorder(root);
        int val = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = val;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (firstNode == null && preNode.val > root.val)
            firstNode = preNode;
        if (firstNode != null && preNode.val > root.val)
            secondNode = root;
        preNode = root;
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5, 6, 7 };
        TreeNode root = new Tree(vals).getRoot();
        new RecoverBinarySearchTree().recoverTree1(root);
        System.out.println(TreeNode.toTreeString(root));
    }

}
