package algorithms;

public class PalindromicSubstrings {
    
    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length, count = 0;
        for (int i = 0; i < len; i++) {
            int m = Math.min(i, len - 1 - i);
            for (int j = 0; j <= m; j++) {
                if (cs[i - j] == cs[i + j]) count++;
                else break;
            }
            if (i == len - 1) break;
            int n = Math.min(i, len - 2 - i);
            for (int j = 0; j <= n; j++) {
                if (cs[i - j] == cs[i + 1 + j]) count++;
                else break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new PalindromicSubstrings().countSubstrings("abccba"));
    }

}
