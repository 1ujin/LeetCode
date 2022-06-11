package algorithms;

import java.util.ArrayList;
import java.util.List;

public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> list = new ArrayList<>();
        char[] pcs = pattern.toCharArray();
        int len = pcs.length;
        outer: for (String word : words) {
            char[] map1 = new char[26], map2 = new char[26];
            char[] wcs = word.toCharArray();
            for (int i = 0; i < len; i++) {
                if (map1[pcs[i] - 'a'] == wcs[i] && map2[wcs[i] - 'a'] == pcs[i])
                    continue;
                else if (map1[pcs[i] - 'a'] != 0 || map2[wcs[i] - 'a'] != 0)
                    continue outer;
                map1[pcs[i] - 'a'] = wcs[i];
                map2[wcs[i] - 'a'] = pcs[i];
            }
            list.add(word);
        }
        return list;
    }

    public static void main(String[] args) {
        String[] words = { "abc", "deq", "mee", "aqq", "dkd", "ccc" };
        System.out.println(new FindAndReplacePattern()
                .findAndReplacePattern(words, "abb"));
    }

}
