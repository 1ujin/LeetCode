package algorithms;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsInAString {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.length() < p.length())
            return list;
        char[] cs1 = s.toCharArray(), cs2 = p.toCharArray();
        int len1 = cs1.length, len2 = cs2.length;
        int[] count1 = new int[26], count2 = new int[26];
        for (char c : cs2)
            count2[c - 'a']++;
        for (int i = 0; i < len2; i++)
            count1[cs1[i] - 'a']++;
        if (compare(count1, count2))
            list.add(0);
        for (int i = 1; i <= len1 - len2; i++) {
            count1[cs1[i - 1] - 'a']--;
            count1[cs1[i + len2 - 1] - 'a']++;
            if (compare(count1, count2))
                list.add(i);
        }
        return list;
    }

    private boolean compare(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString()
                .findAnagrams("cbaebabacd", "abc"));
    }

}
