package algorithms;

import java.util.Stack;

import util.List;
import util.ListNode;

public class AddTwoNumbers2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.val == 0 && l2.val == 0) return new ListNode(0);
        Stack<Integer> stack1 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        Stack<Integer> stack3 = new Stack<>();
        int carry = 0;
        while (carry != 0 || !stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty())
                carry += stack1.pop();
            if (!stack2.isEmpty())
                carry += stack2.pop();
            stack3.push(carry % 10);
            carry /= 10;
        }
        ListNode sum = new ListNode(stack3.pop()), node = sum;
        while (!stack3.isEmpty()) {
            node.next = new ListNode(stack3.pop());
            node = node.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        ListNode l1 = new List(new int[] { 7, 2, 4, 3 }).getHead();
        ListNode l2 = new List(new int[] { 5, 6, 4 }).getHead();
        System.out.println(ListNode.toLinkedListString(
                new AddTwoNumbers2().addTwoNumbers(l1, l2)));
    }

}
