package algorithms;

import java.util.Stack;

public class BasicCalculator {
    
    public int calculate(String s) {
        Stack<Integer> signs = new Stack<>();
        int result = 0, num = 0, sign = 1;
        signs.push(sign);
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                num = num * 10 + c - '0';
                continue;
            }
            result += sign * num;
            num = 0;
            switch (c) {
                case '+':
                    sign = signs.peek();
                    break;
                case '-':
                    sign = -signs.peek();
                    break;
                case '(':
                    signs.push(sign);
                    break;
                case ')':
                    signs.pop();
                    break;
                default:
                    break;
            }
        }
        return result + sign * num;
    }

    public static void main(String[] args) {
        System.out.println(new BasicCalculator().calculate("(1 +(4+5+2)-3)+(6+8)"));
    }

}
