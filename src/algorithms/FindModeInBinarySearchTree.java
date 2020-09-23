package algorithms;

import java.util.Arrays;

import util.Tree;
import util.TreeNode;

public class FindModeInBinarySearchTree {
    
    boolean flag = true;
    int[] arr;
    int last = 0, maxCount = 1, count = 0, len = 0, treeLen = 0;

    public int[] findMode(TreeNode root) {
        inorder(root);
        flag = false;
        count = 0;
        last = 0;
        if (maxCount == 1) len = treeLen;
        arr = new int[len];
        inorder(root);
        return arr;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (flag) {
            treeLen++;
            if (last == root.val) {
                count++;
                if (count > maxCount) {
                    maxCount = count;
                    len = 1;
                } else if (count == maxCount)
                    len++;
            } else {
                last = root.val;
                count = 1;
            }
        } else {
            if (last == root.val) count++;
            else {
                last = root.val;
                count = 1;
            }
            if (count == maxCount)
                arr[--len] = root.val;
        }
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] vals = { 1, 1 << 31, 2, 2 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(Arrays.toString(new FindModeInBinarySearchTree().findMode(root)));
    }

}
