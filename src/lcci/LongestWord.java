package lcci;

import java.util.Arrays;

public class LongestWord {

    public String longestWord(String[] words) {
        int len = words.length;
        Arrays.sort(words, (a, b) -> a.length() == b.length() ?
                a.compareTo(b) : b.length() - a.length());
        for (int i = 0; i < len; i++) {
            String t = words[i];
            if (i < len - 1 && words[i].equals(words[i + 1]))
                continue;
            for (int j = i + 1; j < len; j++) {
                for (int k = j; k < len; k++) {
                    if (t.startsWith(words[k])) {
                        t = t.substring(words[k].length());
                        k = j - 1;
                    }
                    if (t.length() == 0)
                        return words[i];
                }
                t = words[i];
            }
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new LongestWord().longestWord(new String[] { "cat",
                "banana", "dog", "nana", "walk", "walker", "dogwalker" }));
    }

}
