package lcof;

public class Solution19 {
    
    // method 1 recursion
    public boolean isMatch1(String s, String p) {
        if (p.isEmpty())
            return s.isEmpty();
        if (s.isEmpty())
            if (p.length() > 1 && p.charAt(1) == '*')
                return isMatch1(s, p.substring(2)); // 空 有*
            else return false; // 空 无*
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            if (p.length() > 1 && p.charAt(1) == '*')
                return (isMatch1(s.substring(1), p) || isMatch1(s, p.substring(2))); // 匹配 有*
            return isMatch1(s.substring(1), p.substring(1)); // 匹配 无*
        } else if (p.length() > 1 && p.charAt(1) == '*')
            return isMatch1(s, p.substring(2)); // 不匹配 有*
        else return false; // 不匹配 无*
    }
    
    // method 2 dynamic programming top-down fastest
    private int[][] dp;

    public boolean isMatch2(String text, String pattern) {
        dp = new int[text.length() + 1][pattern.length() + 1];
        boolean ret = dp(0, 0, text, pattern);
        return ret;
    }

    private boolean dp(int i, int j, String text, String pattern) {
        if (dp[i][j] != 0)
            return dp[i][j] == 1;
        boolean ans;
        if (j == pattern.length())
            ans = i == text.length();
        else {
            boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*')
                ans = (dp(i, j + 2, text, pattern) || first_match && dp(i + 1, j, text, pattern));
            else ans = first_match && dp(i + 1, j + 1, text, pattern);
        }
        dp[i][j] = ans ? 1 : -1;
        return ans;
    }
    
    // method 3 dynamic programming bottom-up
    public boolean isMatch3(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
                // text的最后一位开始参与匹配，且text的第i个字符是否和pattern的第j个字符相同
                boolean first_match = (i < text.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') // 第j个字符不为最后字符且之后的字符为*
                    // 此时的情况等同于：pattern向后移动两位的情况，或者在是否匹配的同时text向后移动一位的情况
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                else // 第j个字符为最后字符或者之后不为*
                    // 此时的情况等同于：在是否匹配的同时text和pattern均向后移动一位的情况
                    dp[i][j] = first_match && dp[i + 1][j + 1];
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new Solution19().isMatch2("mississippi", "mis*is*p*."));
    }

}
