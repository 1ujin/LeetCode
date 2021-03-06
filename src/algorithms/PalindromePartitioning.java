package algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class PalindromePartitioning {
    
    boolean[][] isPalindrome;
    char[] cs;
    Deque<String> path = new ArrayDeque<>();
    List<List<String>> list = new ArrayList<>();
    
    public List<List<String>> partition(String s) {
        cs = s.toCharArray();
        int len = cs.length;
        if (len == 0)
            return list;
        isPalindrome = new boolean[len][len];
        for (int end = 0; end < len; end++)
            for (int begin = 0; begin <= end; begin++)
                if (cs[begin] == cs[end] && (end - begin <= 2 || isPalindrome[begin + 1][end - 1]))
                    isPalindrome[begin][end] = true;
        dfs(0);
        return list;
    }

    private void dfs(int begin) {
        if (begin >= cs.length) {
            list.add(new ArrayList<>(path));
            return;
        }
        for (int end = begin; end < cs.length; end++) {
            if (isPalindrome[begin][end]) {
                path.addLast(String.copyValueOf(Arrays.copyOfRange(cs, begin, end + 1)));
                dfs(end + 1);
                path.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
    }

}
