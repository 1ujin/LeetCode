package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WordTransformer {
    
    public List<String> findLadders(String beginWord, String endWord,
            List<String> wordList) {
        List<String> stepList = new ArrayList<>();
        if (!wordList.contains(endWord)) return stepList;
        Map<String, List<String>> map = new HashMap<>();
        Set<String> visited = new HashSet<>();
        if (wordList.contains(beginWord))
            wordList.remove(beginWord);
        for (String word : wordList) {
            char[] cs = word.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char t = cs[i];
                cs[i] = '_';
                map.compute(String.valueOf(cs), (k, v) -> {
                    if (v == null)
                        v = new ArrayList<>();
                    v.add(word);
                    return v;
                });
                cs[i] = t;
            }
        }
        dfs(map, visited, stepList, beginWord, endWord);
        if (!stepList.contains(endWord)) return new ArrayList<>();
        return stepList;
    }

    private boolean dfs(Map<String, List<String>> map, Set<String> visited,
            List<String> stepList, String beginWord, String endWord) {
        stepList.add(beginWord);
        visited.add(beginWord);
        if (beginWord.equals(endWord)) return true;
        char[] cs = beginWord.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char t = cs[i];
            cs[i] = '_';
            List<String> v = map.get(String.valueOf(cs));
            if (v != null)
                for (String s : v)
                    if (!visited.contains(s) && dfs(map, visited, stepList, s, endWord))
                        return true;
            cs[i] = t;
        }
        stepList.remove(stepList.size() - 1);
        return false;
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList(new String[] { "hot", "dot",
                "dog", "lot", "log", "cog" }).stream().map(s -> s)
                .collect(Collectors.toList());
        System.out.println(
                new WordTransformer().findLadders("hit", "cog", wordList));
    }

}
