package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindCommonCharacters {
    
    // method 1 hash
    public List<String> commonChars1(String[] A) {
        if (A.length < 1) return new ArrayList<>();
        List<Map<Character, Integer>> maps = new ArrayList<>();
        for (String a : A) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : a.toCharArray())
                map.compute(c, (k, v) -> v == null ? 1 : ++v);
            maps.add(map);
        }
        Map<Character, Integer> result = maps.get(0);
        maps.forEach(map -> {
            Set<Character> set = new HashSet<Character>(result.keySet());
            set.removeAll(map.keySet());
            for (Character c : set)
                result.remove(c);
            for (Map.Entry<Character, Integer> entry : map.entrySet())
                if (result.containsKey(entry.getKey()))
                    result.merge(entry.getKey(), entry.getValue(), Integer::min);
        });
        List<String> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : result.entrySet())
            for (int i = 0; i < entry.getValue(); i++)
                list.add(String.valueOf(entry.getKey()));
        return list;
    }
    
    // method 2 bitmap fastest
    public List<String> commonChars2(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int len = word.length();
            for (int i = 0; i < len; i++)
                freq[word.charAt(i) - 'a']++;
            for (int i = 0; i < 26; i++)
                minfreq[i] = Math.min(minfreq[i], freq[i]);
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < minfreq[i]; j++)
                list.add(String.valueOf((char) (i + 'a')));
        return list;
    }

    public static void main(String[] args) {
        String[] A = { "bella", "label", "roller" };
        System.out.println(new FindCommonCharacters().commonChars2(A));
    }

}
