package algorithms;

public class PermutationInString {
    
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] counts1 = new int[26], counts2 = new int[26];
        for (char c : s1.toCharArray())
            counts1[c - 'a']++;
        int len = s1.length();
        char[] cs = s2.toCharArray();
        for (int i = 0; i < len; i++)
            counts2[cs[i] - 'a']++;
        boolean res = true;
        for (int i = 0; i < 26; i++)
            res = res && counts1[i] == counts2[i];
        if (res)
            return res;
        for (int i = len; i < cs.length; i++) {
            counts2[cs[i - len] - 'a']--;
            counts2[cs[i] - 'a']++;
            res = true;
            for (int j = 0; j < 26; j++)
                res = res && counts1[j] == counts2[j];
            if (res)
                return res;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new PermutationInString().checkInclusion("ab", "eidbaooo"));
    }

}
