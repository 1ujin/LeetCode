package algorithms;

public class RemoveOutermostParentheses {

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int level = 0;
        for (char c : s.toCharArray()) {
            if (c == ')')
                level--;
            if (level > 0)
                sb.append(c);
            if (c == '(')
                level++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new RemoveOutermostParentheses()
                .removeOuterParentheses("(()())(())(()(()))"));
    }

}
