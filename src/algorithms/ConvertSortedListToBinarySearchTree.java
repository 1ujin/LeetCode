package algorithms;

import util.List;
import util.ListNode;
import util.TreeNode;

public class ConvertSortedListToBinarySearchTree {
    
    ListNode head;

    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return inorder(0, len - 1);
    }

    private TreeNode inorder(int left, int right) {
        if (left > right) return null;
        int mid = left + right + 1 >> 1;
        TreeNode root = new TreeNode();
        root.left = inorder(left, mid - 1);
        root.val = head.val;
        head = head.next;
        root.right = inorder(mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] vals = { -10, -3, 0, 5, 9 };
        ListNode head = new List(vals).getHead();
        TreeNode root = new ConvertSortedListToBinarySearchTree().sortedListToBST(head);
        System.out.println(TreeNode.toTreeString(root));
    }

}
