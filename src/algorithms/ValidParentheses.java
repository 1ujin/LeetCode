package algorithms;

import java.util.Stack;

public class ValidParentheses {
    
    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.add(c);
                    break;
                
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{')  return false;
                    break;
                
                default:
                    break;
            }
            
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        isValid("){");
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
