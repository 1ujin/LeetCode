package algorithms;

import java.util.ArrayList;
import java.util.List;

public class RegularExpressionMatching {
    
    // error method * ƥ��ǰ������Ԫ��
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
            if (p.length() > 1 && p.charAt(1) == '*') return isMatch1(s, p.substring(2)); // �� ��*
            else return false; // �� ��*
        }
        if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') {
            if (p.length() > 1 && p.charAt(1) == '*') {
                return (isMatch1(s.substring(1), p) || isMatch1(s, p.substring(2))); // ƥ�� ��*
            }
            return isMatch1(s.substring(1), p.substring(1)); // ƥ�� ��*
        } else if (p.length() > 1 && p.charAt(1) == '*') {
            return isMatch1(s, p.substring(2)); // ��ƥ�� ��*
        } else return false; // ��ƥ�� ��*
    }

    // method 2 dynamic programming top-down fastest
    enum Result {
        TRUE, FALSE
    }
    
    static Result[][] memo;

    public static boolean isMatch2(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        boolean ret = dp(0, 0, text, pattern);
        // ��ӡ��̬�滮��
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
        } else{
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
            	// text�����һλ��ʼ����ƥ�䣬��text�ĵ�i���ַ��Ƿ��pattern�ĵ�j���ַ���ͬ
                boolean first_match = (i < text.length() &&
                                       (pattern.charAt(j) == text.charAt(i) ||
                                        pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') { // ��j���ַ���Ϊ����ַ���֮����ַ�Ϊ*
                	// ��ʱ�������ͬ�ڣ�pattern����ƶ���λ��������������Ƿ�ƥ���ͬʱtext����ƶ�һλ�����
                    dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
                } else { // ��j���ַ�Ϊ����ַ�����֮��Ϊ*
                	// ��ʱ�������ͬ�ڣ����Ƿ�ƥ���ͬʱtext��pattern������ƶ�һλ�����
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        // ��ӡ��̬�滮��
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
        isMatch3("aaa", "a*a");
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
