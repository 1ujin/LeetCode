package algorithms;

import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInString {

    // method 1 stack
    public String removeDuplicates1(String S) {
        Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if (!stack.isEmpty() && c == stack.peek())
                stack.pop();
            else
                stack.push(c);
        }
        char[] cs = new char[stack.size()];
        for (int i = cs.length - 1; i >= 0; i--)
            cs[i] = stack.pop();
        return String.valueOf(cs);
    }

    // method 2 two-pointer fastest
    public String removeDuplicates2(String S) {
        char[] cs = S.toCharArray();
        int j = 0;
        for (int i = 0; i < cs.length; i++, j++) {
            cs[j] = cs[i];
            if (j > 0 && cs[j] == cs[j - 1])
                j -= 2;
        }
        return new String(cs, 0, j);
    }

    public static void main(String[] args) {
        System.out.println(new RemoveAllAdjacentDuplicatesInString()
                .removeDuplicates2("abbaca"));
    }

}
