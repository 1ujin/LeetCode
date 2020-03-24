package lcci;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {
    
    private Map<String, Integer> map;
    
    public WordsFrequency(String[] book) {
        map = new HashMap<>();
        for (String string : book)
            map.compute(string, (k, v) -> (v == null) ? 1 : ++v);
            // map.merge(string, 1, (oldVal, newVal) -> oldVal + newVal);
            // map.put(string, map.getOrDefault(s, 0) + 1);
    }
    
    public int get(String word) {
        return map.getOrDefault(word, 0);
    }

    public static void main(String[] args) {
        WordsFrequency wordsFrequency = new WordsFrequency(new String[] {
                "i", "have", "an", "apple", "he", "have", "a", "pen"
        });
        System.out.println(wordsFrequency.get("you"));
        System.out.println(wordsFrequency.get("have"));
        System.out.println(wordsFrequency.get("an"));
        System.out.println(wordsFrequency.get("apple"));
        System.out.println(wordsFrequency.get("pen"));
    }

}
