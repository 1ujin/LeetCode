package algorithms;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
                "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.",
                "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--",
                "--.." };
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char c : word.toCharArray())
                sb.append(dict[c - 'a']);
            set.add(sb.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        String[] words = { "gin", "zen", "gig", "msg" };
        System.out.println(new UniqueMorseCodeWords()
                .uniqueMorseRepresentations(words));
    }

}
