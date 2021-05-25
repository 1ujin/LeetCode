package algorithms;

import java.util.Deque;
import java.util.LinkedList;

public class ReverseSubstringsBetweenEachPairOfParentheses {

    private char[] cs;
    private int index;

    public String reverseParentheses(String s) {
        cs = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : reverseStack())
            sb.append(c);
        return sb.reverse().toString();
    }

    private Deque<Character> reverseStack() {
        Deque<Character> stack = new LinkedList<>();
        while (index < cs.length) {
            if (cs[index] == '(') {
                index++;
                Deque<Character> reverse = reverseStack();
                while (!reverse.isEmpty())
                    stack.push(reverse.pop());
            } else if (cs[index] == ')') {
                index++;
                return stack;
            } else {
                stack.push(cs[index]);
                index++;
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseSubstringsBetweenEachPairOfParentheses()
                .reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

}
