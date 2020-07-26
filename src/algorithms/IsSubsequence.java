package algorithms;

public class IsSubsequence {
    
    // method 1 two pointer
    public boolean isSubsequence1(String s, String t) {
        char[] cs1 = s.toCharArray(), cs2 = t.toCharArray();
        int len1 = cs1.length, len2 = cs2.length, slow = 0, fast = 0;
        while (slow < len1 && fast < len2) {
            if (cs1[slow] == cs2[fast])
                slow++;
            fast++;
        }
        return slow == len1;
    }
    
    // method 2 dynamic programming
    public boolean isSubsequence2(String s, String t) {
        char[] cs1 = s.toCharArray(), cs2 = t.toCharArray();
        int len1 = cs1.length, len2 = cs2.length;
        int[][] dp = new int[len2 + 1][26];
        for (int i = 0; i < 26; i++)
            dp[len2][i] = len2;
        for (int i = len2 - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (cs2[i] == j + 'a') dp[i][j] = i;
                else dp[i][j] = dp[i + 1][j];
            }
        }
        int add = 0;
        for (int i = 0; i < len1; i++) {
            int j = cs1[i] - 'a';
            if (dp[add][j] == len2) return false;
            add = dp[add][j] + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsSubsequence().isSubsequence2("abc", "ahbgdc"));
    }

}
