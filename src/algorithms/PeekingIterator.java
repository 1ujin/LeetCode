package algorithms;

import java.util.Arrays;
import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    private boolean hasPeeked;
    private Integer peekedElement;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked)
            peekedElement = iterator.next();
        hasPeeked = true;
        return peekedElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasPeeked)
            peekedElement = iterator.next();
        hasPeeked = false;
        return peekedElement;
    }

    @Override
    public boolean hasNext() {
        if (hasPeeked)
            return true;
        return iterator.hasNext();
    }

    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1,2,3).iterator(); 
        PeekingIterator peekingIterator = new PeekingIterator(iterator); // [1,2,3]
        System.out.println(peekingIterator.next());    // 返回 1 ，指针移动到下一个元素 [1,2,3]
        System.out.println(peekingIterator.peek());    // 返回 2 ，指针未发生移动 [1,2,3]
        System.out.println(peekingIterator.next());    // 返回 2 ，指针移动到下一个元素 [1,2,3]
        System.out.println(peekingIterator.next());    // 返回 3 ，指针移动到下一个元素 [1,2,3]
        System.out.println(peekingIterator.hasNext()); // 返回 False
    }

}
