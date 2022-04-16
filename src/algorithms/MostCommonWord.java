package algorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {
        int max = 0;
        String common = "";
        Set<String> bannedSet = new HashSet<>();
        for (String s : banned)
            bannedSet.add(s);
        char[] cs = (paragraph + "#").toLowerCase().toCharArray();
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : cs) {
            if (Character.isLetter(c)) {
                sb.append(c);
                continue;
            }
            String word = sb.toString();
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                int count = map.getOrDefault(word, 0) + 1;
                map.put(word, count);
                if (count > max) {
                    max = count;
                    common = word;
                }
            }
            sb.setLength(0);
        }
        return common;
    }

    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banneds = { "hit" };
        System.out.println(new MostCommonWord().mostCommonWord(paragraph, banneds));
    }

}
