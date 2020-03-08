package lcci;

import java.util.Arrays;

public class Successor {
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    // method 1
    public TreeNode inorderSuccessor1(TreeNode root, TreeNode p) {
        if (root == null) return null;
        // 默认无后继
        TreeNode ret = null;
        // p 在左子树中
        if (p.val < root.val)
            ret = inorderSuccessor1(root.left, p);
        // p 在右子树中
        else if (p.val > root.val)
            ret = inorderSuccessor1(root.right, p);
        // p 为当前根节点，其后继为右子树的最左节点
        else if (root.right != null) {
            root = root.right;
            while (root.left != null) {
                ret = root.left;
                root = root.left;
            }
        }
        // 如果 p 为 root 的左子树根节点且在子树中没有后继，则 root 为后继，否则情况同左子树的情况
        return ret == null && p.val < root.val ? root : ret;
    }
    
    // method 2
    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        if (root == null) return null;
        // 当 p 不在当前根节点左侧时，其后继在右子树中，进入右子树，直到形成下一种情况，返回右子树的情况
        if(p.val >= root.val) return inorderSuccessor2(root.right, p);
        // 当 p 在当前根节点左侧时，进入左子树，直到找到最左节点
        TreeNode ret = inorderSuccessor2(root.left, p);
        // 如果 ret 为空，则返回当前根节点，此根节点有可能为空
        return ret != null ? ret : root;
    }

    public static void main(String[] args) {
        Successor solution = new Successor();
        TreeNode root = solution.new TreeNode(6);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(8);
        root.left.left = solution.new TreeNode(0);
        root.left.right = solution.new TreeNode(4);
        root.right.left = solution.new TreeNode(7);
        root.right.right = solution.new TreeNode(9);
        root.left.right.left = solution.new TreeNode(3);
        root.left.right.right = solution.new TreeNode(5);
        
        long startTime = System.nanoTime();
        int result = solution.inorderSuccessor2(root, root.left).val;
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
