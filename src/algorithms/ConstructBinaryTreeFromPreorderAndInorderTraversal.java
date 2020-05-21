package algorithms;

import java.util.HashMap;
import java.util.Map;

import util.TreeNode;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    
    int[] preorder;
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return dfs(0, 0, inorder.length);
    }

    private TreeNode dfs(int poi, int begin, int end) {
        if (begin == end) return null;
        int rootVal = preorder[poi];
        int ioi = map.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        root.left = dfs(poi + 1, begin, ioi);
        root.right = dfs(poi + ioi - begin + 1, ioi + 1, end);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 };
        int[] inorder = { 9, 3, 15, 20, 7 };
        TreeNode root = new ConstructBinaryTreeFromPreorderAndInorderTraversal()
                .buildTree(preorder, inorder);
        System.out.println(TreeNode.toTreeString(root));
    }

}
