package lcof;

import java.util.Arrays;
import java.util.Stack;

import util.List;
import util.ListNode;

public class Solution06 {
    
    // method 1
    public int[] reversePrint1(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.add(head.val);
            head = head.next;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = stack.pop();
        return result;
    }
    
    // method 2 fastest
    public int[] reversePrint2(ListNode head) {
        if (head == null) return new int[0];
        ListNode pre = null, cur = head, next = head.next;
        int count = 1;
        while (next != null) {
            cur.next = pre;
            pre = cur;
            cur = next;
            next = next.next;
            count++;
        }
        cur.next = pre;
        int[] result = new int[count];
        for (int i = 0; i < result.length; i++) {
            result[i] = cur.val;
            cur = cur.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new List(new int[] { 1, 3, 2 }).getHead();
        System.out.println(Arrays.toString(new Solution06().reversePrint2(head)));
    }

}
