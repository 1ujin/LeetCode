package lcci;

public class LegalBinarySearchTree {
    
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    // depth-first search
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        TreeNode maxLeft = root.left, minRight = root.right;
        while (maxLeft != null && maxLeft.right != null)
            maxLeft = maxLeft.right;
        while (minRight != null && minRight.left != null)
            minRight = minRight.left;
        boolean ret = (maxLeft == null || maxLeft.val < root.val) && (minRight == null || root.val <= minRight.val);
        return ret && isValidBST(root.left) && isValidBST(root.right);
    }
    
    // 此方法节点的值不能为 Integer 型边界值
    @SuppressWarnings("unused")
    private int[] dfs(TreeNode node) {
        if (node.left == null && node.right == null) return new int[] {node.val, node.val};
        int[] left = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        int[] right = new int[] {Integer.MAX_VALUE, Integer.MIN_VALUE};
        if (node.left != null) left = dfs(node.left);
        if (node.right != null) right = dfs(node.right);
        int[] ret = new int[] {Integer.MIN_VALUE, Integer.MAX_VALUE};
        if (left[1] < node.val) ret[0] = node.left == null ? node.val : left[0];
        if (right[0] > node.val) ret[1] = node.right == null ? node.val : right[1];
        return ret;
    }

    public static void main(String[] args) {
        LegalBinarySearchTree solution = new LegalBinarySearchTree();
        TreeNode root = solution.new TreeNode(2);
        root.left = solution.new TreeNode(1);
        root.right = solution.new TreeNode(3);
        
        long startTime = System.nanoTime();
        boolean result = solution.isValidBST(root);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
