package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UncommonWordsFromTwoSentences {

    public String[] uncommonFromSentences(String s1, String s2) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : s1.split(" "))
            map.put(word, map.getOrDefault(word, 0) + 1);
        for (String word : s2.split(" "))
            map.put(word, map.getOrDefault(word, 0) + 1);
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet())
            if (entry.getValue() == 1)
                list.add(entry.getKey());
        return list.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new UncommonWordsFromTwoSentences().uncommonFromSentences("this apple is sweet", "this apple is sour")));
    }

}
