package algorithms;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        char[] cs = pattern.toCharArray();
        String[] words = s.split(" ");
        if (cs.length != words.length) return false;
        for (int i = 0; i < cs.length; i++) {
            if (map1.containsKey(cs[i]) && !map1.get(cs[i]).equals(words[i])
                    || map2.containsKey(words[i]) && map2.get(words[i]) != cs[i])
                return false;
            if (!map1.containsKey(cs[i])) {
                map1.put(cs[i], words[i]);
                map2.put(words[i], cs[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new WordPattern().wordPattern("abba", "dog cat cat dog"));
    }

}
