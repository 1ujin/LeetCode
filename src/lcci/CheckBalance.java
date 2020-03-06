package lcci;

public class CheckBalance {
    
    private class TreeNode {
        @SuppressWarnings("unused")
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(maxHeight(root.left) - maxHeight(root.right)) < 2)
            return isBalanced(root.left) && isBalanced(root.right);
        return false;
    }
    
    private int maxHeight(TreeNode node) {
        if (node == null) return 0;
        return Math.max(maxHeight(node.left), maxHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        CheckBalance solution = new CheckBalance();
        TreeNode tree = solution.new TreeNode(1);
        tree.left = solution.new TreeNode(2);
        tree.right = solution.new TreeNode(2);
        tree.left.left = solution.new TreeNode(3);
        tree.left.right = solution.new TreeNode(3);
        tree.left.left.left = solution.new TreeNode(4);
        tree.left.left.right = solution.new TreeNode(4);
        
        long startTime = System.nanoTime();
        boolean result = solution.isBalanced(tree);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
