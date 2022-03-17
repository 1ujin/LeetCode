package algorithms;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestWordInDictionary {

    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();
            else
                return b.compareTo(a);
        });
        String longest = "";
        Set<String> set = new HashSet<>();
        set.add(longest);
        for (String word : words) {
            if (set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                longest = word;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        String[] words = { "a", "banana", "app", "appl", "ap", "apply", "apple" };
        System.out.println(new LongestWordInDictionary().longestWord(words));
    }

}
