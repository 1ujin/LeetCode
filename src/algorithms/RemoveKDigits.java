package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveKDigits {
    
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new LinkedList<>();
        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && c < stack.peek()) {
                stack.pop();
                k--;
            }
            if (c != '0' || !stack.isEmpty())
                stack.push(c);
        }
        while (!stack.isEmpty() && k-- > 0) stack.pop();
        if (stack.isEmpty()) return "0";
        char[] cs = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--)
            cs[i] = stack.pop();
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveKDigits().removeKdigits("1432219", 3));
    }

}
