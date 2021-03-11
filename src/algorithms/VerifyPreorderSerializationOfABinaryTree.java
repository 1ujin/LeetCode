package algorithms;

import java.util.Stack;

public class VerifyPreorderSerializationOfABinaryTree {

    // method 1 stack
    public boolean isValidSerialization1(String preorder) {
        Stack<Boolean> stack = new Stack<>();
        for (String s : preorder.split(",")) {
            while (s.equals("#") && !stack.isEmpty() && stack.peek()) {
                stack.pop();
                if (stack.isEmpty())
                    return false;
                stack.pop();
            }
            stack.push(s.equals("#"));
        }
        return stack.size() == 1 && stack.peek();
    }
    
    // method 2 fastest
    public boolean isValidSerialization2(String preorder) {
        int count = 1;
        char[] cs = preorder.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != ',')
                continue;
            if (--count < 0)
                return false;
            if (cs[i - 1] != '#')
                count += 2;
        }
        return count == (cs[cs.length - 1] == '#' ? 1 : -1); 
    }

    public static void main(String[] args) {
        System.out.println(new VerifyPreorderSerializationOfABinaryTree()
                .isValidSerialization2("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

}
