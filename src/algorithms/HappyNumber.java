package algorithms;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    
    // method 1 HashSet
    public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);
            int tmp = 0;
            while (n > 0) {
                tmp += (n % 10) * (n % 10);
                n /= 10;
            }
            n = tmp;
        }
        return n == 1;
    }
    
    // method 2 two pointer
    public boolean isHappy2(int n) {
        int ptr1 = n, ptr2 = n;
        do {
            ptr1 = next(ptr1);
            ptr2 = next(next(ptr2));
        } while (ptr1 != ptr2);
        return ptr1 == 1;
    }
    
    private int next(int n) {
        int next = 0;
        while (n > 0) {
            next += (n % 10) * (n % 10);
            n /= 10;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy2(19));
    }

}
