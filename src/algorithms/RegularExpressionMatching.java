package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {
    
    // error method * 匹配前边所有元素
    public static boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        char[] pChars = p.toCharArray();
        List<ArrayList<Character>> pList = new ArrayList<ArrayList<Character>>();
        pList.add(new ArrayList<Character>());
        int pIndex = 0;
        for (char pChar : pChars) {
            if (pChar == '*') {
                pList.add(new ArrayList<Character>());
                pIndex++;
            } else {
                pList.get(pIndex).add(pChar);
            }
        }
        for (ArrayList<Character> pSubChars : pList) {
            System.out.println(pSubChars);
        }
        int i = 0, j = 0;
        exit:
        for (pIndex = 0; pIndex < pList.size(); pIndex++) {
            ArrayList<Character> pSubChars = pList.get(pIndex);
            while (i + pSubChars.size() < s.length()) {
                char[] sSubChars = s.substring(i, i + pSubChars.size()).toCharArray();
                for (j = 0; j < pSubChars.size(); j++) {
                    System.out.printf("%c == %c\n", sSubChars[j], pSubChars.get(j));
                    if (pSubChars.get(j) == sSubChars[j] || pSubChars.get(j) == '.') {
                        i++;
                    } else {
                        continue exit;
                    }
                }
            }
        }
        System.out.printf("%d, %d, %d\n", i, j, pIndex);
        if (i == s.length() - 1 && pIndex == pList.size()) return true;
        return false;
    }
    
    // method 1 recursion
    public static boolean isMatch1(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        if (s.isEmpty()) {
            if (p.length() > 1 && p.charAt(1) == '*') return isMatch1(s, p.substring(2)); // 空 有*
            else return false; // 空 无*
        }
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            if (p.length() > 1 && p.charAt(1) == '*') {
                return (isMatch1(s.substring(1), p) || isMatch1(s, p.substring(2))); // 匹配 有*
            }
            return isMatch1(s.substring(1), p.substring(1)); // 匹配 无*
        } else if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch1(s, p.substring(2)); // 不匹配 有*
        } else return false; // 不匹配 无*
    }

    // method 2 dynamic programming top-down fastest
    enum Result {
        TRUE, FALSE
    }
    
    static Result[][] memo;

    public static boolean isMatch2(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        boolean ret = dp(0, 0, text, pattern);
        // 打印动态规划表
        for (int j = -1; j < text.length() + 1; j++) {
			System.out.printf("%-10s", j);
		}
        System.out.println();
        for (int i = 0; i < pattern.length() + 1; i++) {
        	System.out.printf("%-10d", i);
			for (int j = 0; j < text.length() + 1; j++) {
				System.out.printf("%-10s", memo[j][i]);
			}
			System.out.println();
		}
        return ret;
    }

    public static boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = i == text.length();
        } else {
            boolean first_match = (i < text.length() &&
                                   (pattern.charAt(j) == text.charAt(i) ||
                                    pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (dp(i, j + 2, text, pattern) ||
                       first_match && dp(i + 1, j, text, pattern));
            } else {
                ans = first_match && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }
    
    // method 3 dynamic programming bottom-up
    public static boolean isMatch3(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length() - 1; j >= 0; j--) {
            	// text的最后一位开始参与匹配，且text的第i个字符是否和pattern的第j个字符相同
                boolean first_match = (i < text.length() &&
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') { // 第j个字符不为最后字符且之后的字符为*
                	// 此时的情况等同于：pattern向后移动两位的情况，或者在是否匹配的同时text向后移动一位的情况
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else { // 第j个字符为最后字符或者之后不为*
                	// 此时的情况等同于：在是否匹配的同时text和pattern均向后移动一位的情况
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        // 打印动态规划表
        for (int j = -1; j < text.length() + 1; j++) {
			System.out.printf("%-10s", j);
		}
        System.out.println();
        for (int i = 0; i < pattern.length() + 1; i++) {
        	System.out.printf("%-10d", i);
			for (int j = 0; j < text.length() + 1; j++) {
				System.out.printf("%-10s", dp[j][i]);
			}
			System.out.println();
		}
        return dp[0][0];
    }
    
    public static void main(String[] args) {
        long startTime = System.nanoTime();
        boolean result = isMatch3("aaa", "a*a");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
