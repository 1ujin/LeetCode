package lcci;

public class PartitionList {
    
    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    
    public ListNode partition(ListNode head, int x) {
        ListNode cursor = head, tmp = head;
        while (cursor != null && cursor.next != null) {
            if (cursor.next.val < x) {
                tmp = cursor.next;
                cursor.next = cursor.next.next;
                tmp.next = head;
                head = tmp;
            } else cursor = cursor.next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        PartitionList solution = new PartitionList();
        ListNode head = solution.new ListNode(3);
        head.next = solution.new ListNode(5);
        head.next.next = solution.new ListNode(8);
        head.next.next.next = solution.new ListNode(5);
        head.next.next.next.next = solution.new ListNode(10);
        head.next.next.next.next.next = solution.new ListNode(2);
        head.next.next.next.next.next.next = solution.new ListNode(1);
        
        long startTime = System.nanoTime();
        head = solution.partition(head, 3);
        long endTime = System.nanoTime();
        while (head.next != null) {
            System.out.printf("%d->", head.val);
            head = head.next;
        }
        System.out.println(head.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
