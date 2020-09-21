package algorithms;

import util.Tree;
import util.TreeNode;

public class BinaryTreeCameras {
    
    // method 1
    public int minCameraCover1(TreeNode root) {
        return dfs1(root)[1];
    }

    private int[] dfs1(TreeNode root) {
        if (root == null) return new int[] { Integer.MAX_VALUE >> 1, 0, 0 };
        int[] leftState = dfs1(root.left), rightState = dfs1(root.right);
        int[] rootState = new int[3];
        rootState[0] = leftState[2] + rightState[2] + 1;
        rootState[1] = Math.min(rootState[0], Math.min(
                leftState[0] + rightState[1], leftState[1] + rightState[0]));
        rootState[2] = Math.min(rootState[0], leftState[1] + rightState[1]);
        return rootState;
    }
    
    // method 2 fastest
    int camera = 0;
    
    public int minCameraCover2(TreeNode root) {
        if (dfs2(root) == 0)
            camera++;
        return camera;
    }

    private int dfs2(TreeNode root) {
        if (root == null) return 1;
        int left = dfs2(root.left), right = dfs2(root.right);
        if (left == 0 || right == 0) {
            camera++;
            return 2;
        } else if (left + right > 2) return 1;
        else if (left == 1 && right == 1) return 0;
        else return -1;
    }

    public static void main(String[] args) {
        int[] vals = { 0, 0, Integer.MIN_VALUE, 0, Integer.MIN_VALUE, 0,
                Integer.MIN_VALUE, Integer.MIN_VALUE, 0 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new BinaryTreeCameras().minCameraCover2(root));
    }

}
