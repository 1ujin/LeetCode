package algorithms;

import algorithms.MergeTwoSortedLists;
import algorithms.MergeTwoSortedLists.ListNode;

public class MergeKSortedLists {
    
    // method 1 recursion slowest
    public static ListNode mergeKLists1(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode minNode = lists[0];
        int minIndex = 0;
        while (minNode == null) {
            minIndex++;
            if (minIndex >= lists.length) return minNode;
            minNode = lists[minIndex];
        }
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null) continue;
            if (minNode.val > lists[i].val) {
                minNode = lists[i];
                minIndex = i;
            }
        }
        lists[minIndex] = lists[minIndex].next;
        minNode.next = mergeKLists1(lists);
        return minNode;
    }
    
    // method 2 divide and conquer fastest
    public static ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        int len = lists.length;
        while (len > 1) {
            for (int i = 0; i < lists.length / 2; i++) {
                lists[i] = MergeTwoSortedLists.mergeTwoLists2(lists[i], lists[len - 1 - i]);
            }
            len = (len + 1) / 2;
        }
        return lists[0];
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        
        ListNode[] lists = new ListNode[] {l1, l2, l3};
        
        long startTime = System.nanoTime();
        ListNode l = mergeKLists2(lists);
        long endTime = System.nanoTime();
        while (l.next != null) {
            System.out.printf("%d->", l.val);
            l = l.next;
        }
        System.out.println(l.val);
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
