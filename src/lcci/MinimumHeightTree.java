package lcci;

public class MinimumHeightTree {
    
    @SuppressWarnings("unused")
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return addChild(nums, 0, nums.length - 1);
    }
    
    private TreeNode addChild(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = addChild(nums, left, mid - 1);
        node.right = addChild(nums, mid + 1, right);
        return node;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        new MinimumHeightTree().sortedArrayToBST(new int[] {-10, 3, 0, 5, 9});
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
