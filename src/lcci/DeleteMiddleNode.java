package lcci;

public class DeleteMiddleNode {
    
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        DeleteMiddleNode solution = new DeleteMiddleNode();
        ListNode head = solution.new ListNode(1);
        head.next = solution.new ListNode(2);
        head.next.next = solution.new ListNode(3);
        head.next.next.next = solution.new ListNode(4);
        head.next.next.next.next = solution.new ListNode(5);
        
        long startTime = System.nanoTime();
        solution.deleteNode(head.next.next);
        long endTime = System.nanoTime();
        while (head.next != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
        System.out.println(head.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
