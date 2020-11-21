package algorithms;

import java.util.Arrays;

public class LargestSubstringBetweenTwoEqualCharacters {
    
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] first = new int[26], last = new int[26];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (first[cs[i] - 'a'] == -1)
                first[cs[i] - 'a'] = i;
            if (last[cs[i] - 'a'] < i)
                last[cs[i] - 'a'] = i;
        }
        int max = 0;
        for (int i = 0; i < 26; i++)
            max = Math.max(max, last[i] - first[i]);
        return max - 1;
    }

    public static void main(String[] args) {
        System.out.println(new LargestSubstringBetweenTwoEqualCharacters()
                .maxLengthBetweenEqualCharacters("cabbac"));
    }

}
