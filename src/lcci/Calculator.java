package lcci;

import java.util.Stack;

public class Calculator {
    
    private Stack<Integer> num = new Stack<>();
    private Stack<Character> op = new Stack<>();
    
    public int calculate(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        for (int i = 0; i < len; i++) {
            char c = cs[i];
            if (c == ' ') continue;
            if (c == '+' || c == '-') op.push(c);
            else if (c == '*') {
                while (cs[++i] == ' ');
                int t = cs[i] - '0';
                while (i < len - 1 && cs[i + 1] >= '0')
                    t = t * 10 + (cs[++i] - '0');
                num.push(num.pop() * t);
            } else if (c == '/') {
                while (cs[++i] == ' ');
                int t = cs[i] - '0';
                while (i < len - 1 && cs[i + 1] >= '0')
                    t = t * 10 + (cs[++i] - '0');
                num.push(num.pop() / t);
            } else {
                num.push(c - '0');
                while (i < len - 1 && cs[i + 1] >= '0')
                    num.push(num.pop() * 10 + (cs[++i] - '0'));
            }
        }
        int result = 0;
        while (!op.isEmpty()) {
            if (op.pop() == '+') result += num.pop();
            else result -= num.pop();
        }
        result += num.pop();
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Calculator().calculate("1*2-3/4+5*6-7*8+9/10"));
    }

}
