package algorithms;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    
    // method 1
    public static List<String> generateParenthesis1(int n) {
        List<String> list = new ArrayList<>();
        backTrack(list, "", 0, 0, n);
        return list;
    }
    
    private static void backTrack(List<String> list, String str, int open, int close, int n) {
        // 分支一，增加左括号，也就是增加一对括号
        if (open < n) backTrack(list, str + "(", open + 1, close, n);
        // 分支二，增加右括号，也就是闭合已有的左括号，完成一对括号
        if (close < open) backTrack(list, str + ")", open, close + 1, n);
        // 所有括号均闭合且数量满足要求
        if (close == open && open == n) {
            list.add(str);
            return;
        }
    }
    
    // method 2
    public static List<String> generateParenthesis2(int n) {
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int c = 0; c < n; c++)
                for (String left: generateParenthesis2(c))
                    for (String right: generateParenthesis2(n-1-c))
                        ans.add("(" + left + ")" + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        generateParenthesis1(3);
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
