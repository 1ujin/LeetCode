package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import util.ListNode;

class LinkedListRandomNode1 extends LinkedListRandomNode {

    private Random rand;
    private List<Integer> list;

    public LinkedListRandomNode1(ListNode head) {
        rand = new Random();
        list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
    }

    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }

}

class LinkedListRandomNode2 extends LinkedListRandomNode {

    private Random rand;
    private ListNode head;

    public LinkedListRandomNode2(ListNode head) {
        rand = new Random();
        this.head = head;
    }

    public int getRandom() {
        int val = 0, i = 1;
        for (ListNode node = head; node != null; node = node.next, i++)
            if (rand.nextInt(i) == 0)
                val = node.val;
        return val;
    }

}

public class LinkedListRandomNode {

    public int getRandom() {
        return 0;
    }

    public static void main(String[] args) {
        ListNode head = new util.List(1, 2, 3).getHead();
        LinkedListRandomNode listRandomNode = new LinkedListRandomNode1(head);
        System.out.println(listRandomNode.getRandom());
        System.out.println(listRandomNode.getRandom());
        System.out.println(listRandomNode.getRandom());
        System.out.println(listRandomNode.getRandom());
        System.out.println(listRandomNode.getRandom());
    }

}
