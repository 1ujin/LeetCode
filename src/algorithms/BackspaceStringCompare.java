package algorithms;

import java.util.ArrayDeque;
import java.util.Deque;

public class BackspaceStringCompare {
    
    // method 1 stack
    public boolean backspaceCompare1(String S, String T) {
        Deque<Character> stack1 = new ArrayDeque<>(), stack2 = new ArrayDeque<>();
        for (char c : S.toCharArray()) {
            if (c != '#')
                stack1.push(c);
            else if (!stack1.isEmpty())
                stack1.poll();
        }
        for (char c : T.toCharArray()) {
            if (c != '#')
                stack2.push(c);
            else if (!stack2.isEmpty())
                stack2.poll();
        }
        while (!stack1.isEmpty())
            if (stack2.isEmpty() || stack1.poll() != stack2.poll())
                return false;
        return stack2.isEmpty();
    }
    
    // method 2 two pointer fastest
    public boolean backspaceCompare2(String S, String T) {
        char[] cs1 = S.toCharArray(), cs2 = T.toCharArray();
        int i1 = 0, j1 = 0, i2 = 0, j2 = 0;
        while (j1 < cs1.length) {
            if (cs1[j1] != '#')
                cs1[i1++] = cs1[j1];
            else if (i1 > 0) i1--;
            j1++;
        }
        while (j2 < cs2.length) {
            if (cs2[j2] != '#')
                cs2[i2++] = cs2[j2];
            else if (i2 > 0) i2--;
            j2++;
        }
        if (i1 != i2) return false;
        for (int i = 0; i < i1; i++)
            if (cs1[i] != cs2[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        String S = "ab#c", T = "ad#c";
        System.out.println(new BackspaceStringCompare().backspaceCompare2(S, T));
    }

}
