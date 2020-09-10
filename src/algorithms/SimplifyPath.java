package algorithms;

import java.util.Stack;

public class SimplifyPath {
    
    // method 1
    public String simplifyPath1(String path) {
        char[] cs = path.toCharArray();
        Stack<String> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '/' && sb.length() > 0) {
                if (sb.toString().equals("..")) {
                    if (!stack.isEmpty()) stack.pop();
                    sb = new StringBuilder();
                } else if (!sb.toString().equals("."))
                    stack.push(sb.toString());
                sb = new StringBuilder();
            } else if (cs[i] != '/') {
                sb.append(cs[i]);
                if (i == cs.length - 1 && sb.toString().equals("..")) {
                    sb = new StringBuilder();
                    if (!stack.isEmpty()) stack.pop();
                }
            }
        }
        if (sb.length() > 0 && !sb.toString().equals("."))
            stack.push(sb.toString());
        if (stack.isEmpty()) return "/";
        sb = new StringBuilder();
        for (String string : stack) {
            sb.append('/');
            sb.append(string);
        }
        return sb.toString();
    }
    
    // method 2
    public String simplifyPath2(String path) {
        String[] strings = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String string : strings) {
            if (string.length() == 0 || string.equals(".")) continue;
            if (string.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else stack.push(string);
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        for (String string : stack) {
            sb.append('/');
            sb.append(string);
        }
        return sb.toString();
    }
    
    // method 3 fastest
    public String simplifyPath3(String path) {
        path += '/';
        char[] chs = path.toCharArray();
        int top = -1;
        for (char c : chs) {
            if (top == -1 || c != '/')
                chs[++top] = c;
            else if (chs[top] == '.' && chs[top - 1] == '/')
                top--;
            else if (chs[top] == '.' && chs[top - 1] == '.' && chs[top - 2] == '/') {
                top -= 2;
                while (top > 0 && chs[--top] != '/');
            }  else if (chs[top] != '/')
                chs[++top] = c;
        }
        if (top > 0 && chs[top] == '/')
            top--;
        return new String(chs, 0, top + 1);
    }

    public static void main(String[] args) {
        System.out.println(new SimplifyPath().simplifyPath3("/a//b////c/d//././/.."));
    }

}
