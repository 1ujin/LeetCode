package lcci;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StackOfPlates {
    
    List<Stack<Integer>> stacks;
    int capacity;

    public StackOfPlates(int cap) {
        if (cap > 0) stacks = new ArrayList<>();
        capacity = cap;
    }
    
    public void push(int val) {
        if (capacity < 1) return;
        if (stacks.isEmpty() || stacks.get(stacks.size() - 1).size() >= capacity) stacks.add(new Stack<>());
        stacks.get(stacks.size() - 1).push(val);
//        int i = 0;
//        while (i < stacks.size()) {
//            if (stacks.get(i).size() < capacity) {
//                stacks.get(i).push(val);
//                break;
//            }
//            i++;
//        }
//        if (i == stacks.size()) {
//            stacks.add(new Stack<>());
//            stacks.get(i).push(val);
//        }
    }
    
    public int pop() {
        if (capacity < 1 || stacks.size() < 1) return -1;
        int last = stacks.size() - 1;
        int ret = stacks.get(last).pop();
        if (stacks.get(last).size() == 0) stacks.remove(last);
        return ret;
    }
    
    public int popAt(int index) {
        if (capacity < 1 || index >= stacks.size()) return -1;
        int ret = stacks.get(index).pop();
        if (stacks.get(index).size() == 0) stacks.remove(index);
        return ret;
    }
    
    public static void main(String[] args) {
        StackOfPlates obj = new StackOfPlates(2);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        System.out.println(obj.popAt(0));
        System.out.println(obj.popAt(0));
        System.out.println(obj.popAt(0));
    }

}
