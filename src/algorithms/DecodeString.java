package algorithms;

import java.util.Stack;

public class DecodeString {
    
    public String decodeString(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                countStack.push(count);
                sbStack.push(sb);
                sb = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int lastCount = countStack.pop();
                for (int i = 0; i < lastCount; i++)
                    tmp.append(sb);
                sb = sbStack.pop().append(tmp);
            } else if (c >= '0' && c <= '9')
                count = count * 10 + c - '0';
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
    }

}
