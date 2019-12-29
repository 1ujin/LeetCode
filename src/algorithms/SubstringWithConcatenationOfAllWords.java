package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords {
    
    // method 1
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        int wordNum = words.length;
        if (wordNum == 0) return list;
        int wordLen = words[0].length();
        int substrLen = wordNum * wordLen;
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        loop:
        for (int i = 0; i <= s.length() - substrLen; i++) {
            String substr = s.substring(i, i + substrLen);
            Map<String, Integer> substrMap = new HashMap<>();
            for (int j = 0; j <= substr.length() - wordLen; j += wordLen) {
                String subSubstr = substr.substring(j, j + wordLen);
                substrMap.put(subSubstr, substrMap.getOrDefault(subSubstr, 0) + 1);
                if (!wordMap.containsKey(subSubstr) || substrMap.get(subSubstr) > wordMap.get(subSubstr)) {
                    continue loop;
                }
            }
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        List<Integer> list = findSubstring("wordgoodgoodgoodbestword", new String[] {"good", "best", "word"});
        long endTime = System.nanoTime();
        System.out.println(list);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
