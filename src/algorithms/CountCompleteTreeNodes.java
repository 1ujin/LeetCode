package algorithms;

import util.Tree;
import util.TreeNode;

public class CountCompleteTreeNodes {
    
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int level = 0;
        for (TreeNode node = root; node.left != null; node = node.left) level++;
        int lo = 1 << level, hi = (lo << 1) - 1;
        while (lo < hi) {
            int mid = lo + hi + 1 >> 1;
            if (exists(root, level, mid)) lo = mid;
            else hi = mid - 1;
        }
        return lo;
    }

    /**
     * @param root     根节点。
     * @param level    所在层数，即最大层数，且根节点为第 0 层。
     * @param routeBmp 节点的路径位图，从左数第二位开始，为 0 则进入左子节点，为 1 则进入右子节点。
     * @return 节点是否存在。
     */
    private boolean exists(TreeNode root, int level, int routeBmp) {
        TreeNode node = root;
        while (node != null && level-- > 0)
            node = (routeBmp & 1 << level) == 0 ? node.left : node.right;
        return node != null;
    }

    public static void main(String[] args) {
        int[] vals = { 1, 2, 3, 4, 5, 6 };
        TreeNode root = new Tree(vals).getRoot();
        System.out.println(new CountCompleteTreeNodes().countNodes(root));
    }

}
