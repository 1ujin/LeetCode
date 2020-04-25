package lcof;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution38 {
    
    public String[] permutation(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        boolean[] isUsed = new boolean[cs.length];
        List<String> list = new ArrayList<>();
        backtrack(cs, isUsed, list, new StringBuilder());
        return list.stream().toArray(String[]::new);
    }

    private void backtrack(char[] cs, boolean[] isUsed, List<String> list,
            StringBuilder sb) {
        if (sb.length() == cs.length) list.add(sb.toString());
        else for (int i = 0; i < cs.length; i++) {
            if (!isUsed[i] && (i == 0 || cs[i] != cs[i - 1] || isUsed[i - 1])) {
                sb.append(cs[i]);
                isUsed[i] = true;
                backtrack(cs, isUsed, list, sb);
                sb.deleteCharAt(sb.length() - 1);
                isUsed[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution38().permutation("abc")));
    }

}
