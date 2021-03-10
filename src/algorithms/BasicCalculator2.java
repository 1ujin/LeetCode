package algorithms;

import java.util.Stack;

public class BasicCalculator2 {
    
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        char sign = '+';
        int num = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ')
                continue;
            if (c >= '0' && c <= '9') {
                num *= 10;
                num += c - '0';
                continue;
            }
            switch(sign) {
                case '+':
                case '-':
                    stack.push(num * (44 - sign));
                    break;
                case '*':
                    stack.push(stack.pop() * num);
                    break;
                case '/':
                    stack.push(stack.pop() / num);
                    break;
                default:
                    break;
            }
            sign = c;
            num = 0;
        }
        switch(sign) {
            case '+':
            case '-':
                stack.push(num * (44 - sign));
                break;
            case '*':
                stack.push(stack.pop() * num);
                break;
            case '/':
                stack.push(stack.pop() / num);
                break;
            default:
                break;
        }
        return stack.stream().reduce(0, Integer::sum);
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator2().calculate("3+5 / 2"));
    }

}
