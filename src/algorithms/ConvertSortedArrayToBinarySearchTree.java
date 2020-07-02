package algorithms;

import util.TreeNode;

public class ConvertSortedArrayToBinarySearchTree {
    
    int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        int lo = 0, hi = nums.length - 1;
        return dfs(lo, hi);
    }

    private TreeNode dfs(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + hi + 1 >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(lo, mid - 1);
        root.right = dfs(mid + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        int[] nums = { -10, -3, 0, 5, 9 };
        System.out.println(TreeNode.toTreeString(new ConvertSortedArrayToBinarySearchTree().sortedArrayToBST(nums)));
    }

}
