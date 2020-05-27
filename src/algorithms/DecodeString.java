package algorithms;

import java.util.LinkedList;

public class DecodeString {
    
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> multiStack = new LinkedList<>();
        LinkedList<String> sbStack = new LinkedList<>();
        for (Character c : s.toCharArray()) {
            if (c == '[') {
                multiStack.addLast(multi);
                sbStack.addLast(sb.toString());
                sb = new StringBuilder();
                multi = 0;
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int lastMulti = multiStack.removeLast();
                for (int i = 0; i < lastMulti; i++)
                    tmp.append(sb);
                sb = new StringBuilder(sbStack.removeLast() + tmp);
            } else if (c >= '0' && c <= '9')
                multi = multi * 10 + Integer.parseInt(c + "");
            else sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
    }

}
