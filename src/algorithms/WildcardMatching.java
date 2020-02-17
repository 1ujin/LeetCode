package algorithms;

public class WildcardMatching {
    
    // method 1 recursion time out
    public static boolean isMatch1(String s, String p) {
        if (s.equals(p))
            return true;
        if (p.isEmpty())
            return s.isEmpty();
        if (s.isEmpty())
            return p.charAt(0) == '*' && isMatch1(s, p.substring(1));
        if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0))
            return isMatch1(s.substring(1), p.substring(1));
        if (p.charAt(0) == '*')
            return isMatch1(s.substring(0), p.substring(1)) || isMatch1(s.substring(1), p.substring(0));
        return false;
    }
    
    // method 2 dynamic programming overlapping subproblems top-down
    public static boolean isMatch2(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        // 当 s 和 p 均为空时结果为 true
        dp[0][0] = true;
        // 当 s 不为空且 p 为空时全部匹配结果均为 false 即 dp[1][0] ~ dp[p.length()][0] 均为 false
        // 初始化 s 为空且 p 不为空时的情况
        for (int i = 1; i <= p.length(); i++)
            if (p.charAt(i - 1) == '*')
                dp[0][i] = dp[0][i - 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
    
    // method 3 two pointer fastest
    public static boolean isMatch3(String s, String p) {
        int i = 0, j = 0, iAsterisk = -1, jAsterisk = -1, sLen = s.length(), pLen = p.length();
        while (i < sLen) {
            if (j < pLen && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                i++;
                j++;
            } else if (j < pLen && p.charAt(j) == '*') {
                iAsterisk = i;
                jAsterisk = j;
                j++;
            } else if (jAsterisk >= 0) { // 位置大于等于 0 说明字符串中存在 * 此处 j 位置可能等于字符串长度
                i = iAsterisk + 1;
                j = jAsterisk + 1;
                iAsterisk++;
            } else return false;
        }
        while (j < pLen && p.charAt(j) == '*') j++;
        return j == pLen;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        boolean result = isMatch3("aa", "*");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
