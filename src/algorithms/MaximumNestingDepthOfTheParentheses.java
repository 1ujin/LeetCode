package algorithms;

public class MaximumNestingDepthOfTheParentheses {

    public int maxDepth(String s) {
        int max = 0, depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '(')
                depth++;
            else if (c == ')')
                depth--;
            max = Math.max(max, depth);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNestingDepthOfTheParentheses()
                .maxDepth("(1+(2*3)+((8)/4))+1"));
    }

}
