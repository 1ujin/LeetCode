package lcof;

import java.util.HashMap;

import util.TreeNode;

public class Solution07 {
    
    // method 1 divide and conquer
    private int[] preorder, inorder;
    int parent = 0;

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        this.preorder = preorder;
        this.inorder = inorder;
        return divideConquer(0, inorder.length);
    }

    private TreeNode divideConquer(int begin, int end) {
        int pivot = begin;
        for (; pivot < end; pivot++)
            if (inorder[pivot] == preorder[parent])
                break;
        TreeNode node = new TreeNode(preorder[parent++]);
        if (pivot > begin)
            node.left = divideConquer(begin, pivot);
        if (pivot + 1 < end)
            node.right = divideConquer(pivot + 1, end);
        return node;
    }
    
    // method 2 fastest
    private int pre = 0;
    private int in = 0;

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        return buildTree2(preorder, inorder, Integer.MAX_VALUE + 1);
    }

    private TreeNode buildTree2(int[] preorder, int[] inorder, long stop) {
        // 数组为空则返回null
        if (pre == preorder.length)
            return null;
        // 中序遍历序列数组顺序值等于终止值，则依次后移
        // 表示此节点为空
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        // 按照先序遍历顺序值新建节点
        int val = preorder[pre++];
        TreeNode root = new TreeNode(val);
        // 建立左节点，终止值为当前节点值
        root.left = buildTree2(preorder, inorder, val);
        // 建立右节点，终止值为上一节点值
        root.right = buildTree2(preorder, inorder, stop);
        // 返回当前节点
        return root;
    }
    
    // method 3
    private int[] po;
    HashMap<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        po = preorder;
        for (int i = 0; i < inorder.length; i++)
            map.put(inorder[i], i);
        return recursive(0, 0, inorder.length);
    }

    private TreeNode recursive(int pivot, int begin, int end) {
        if (begin == end) return null;
        TreeNode node = new TreeNode(po[pivot]);
        int newPivot = map.get(po[pivot]);
        node.left = recursive(pivot + 1, begin, newPivot);
        node.right = recursive(pivot - begin + newPivot + 1, newPivot + 1, end);
        return node;
    }

    public static void main(String[] args) {
        int[] preorder = { 3, 9, 20, 15, 7 }, inorder = { 9, 3, 15, 20, 7 };
        System.out.println(TreeNode
                .toTreeString(new Solution07().buildTree3(preorder, inorder)));
    }

}
