package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class WordBreak2 {
    
    // method 1 time limit exceeded
    char[] cs;
    List<String> list;
    List<char[]> wordList;

    public List<String> wordBreak1(String s, List<String> wordDict) {
        cs = s.toCharArray();
        list = new ArrayList<>();
        wordList = new ArrayList<>();
        for (String word : wordDict)
            wordList.add(word.toCharArray());
        recur(0, new StringBuilder());
        return list;
    }

    private void recur(int index, StringBuilder sb) {
        if (index == cs.length)
            list.add(sb.toString());
        for (char[] word : wordList) {
            int i = 0;
            for (; i < word.length && i < cs.length - index && cs[i + index] == word[i]; i++);
            if (i == word.length) {
                StringBuilder newSb = new StringBuilder(sb);
                if (newSb.length() != 0) newSb.append(' ');
                newSb.append(word);
                recur(index + i, newSb);
            }
        }
    }
    
    // method 2 backtracking
    String s;
    int len;
    Map<Integer, List<Deque<String>>> map;
    Set<String> wordSet;
    
    public List<String> wordBreak2(String s, List<String> wordDict) {
        this.s = s;
        len = s.length();
        map = new HashMap<>();
        wordSet = new HashSet<>(wordDict);
        List<Deque<String>> wordBreaks = backtrack(0);
        return wordBreaks.stream().map(wb -> String.join(" ", wb))
                .collect(Collectors.toList());
    }

    private List<Deque<String>> backtrack(int begin) {
        if (!map.containsKey(begin)) {
            List<Deque<String>> wordBreaks = new ArrayList<>();
            if (begin == len)
                wordBreaks.add(new LinkedList<>());
            for (int end = begin + 1; end <= len; end++) {
                String word = s.substring(begin, end);
                if (!wordSet.contains(word)) continue;
                List<Deque<String>> nextWordBreaks = backtrack(end);
                for (Deque<String> nextWordBreak : nextWordBreaks) {
                    Deque<String> wordBreak = new LinkedList<>(nextWordBreak);
                    wordBreak.offerFirst(word);
                    wordBreaks.add(wordBreak);
                }
            }
            map.put(begin, wordBreaks);
        }
        return map.get(begin);
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(new WordBreak2().wordBreak2(s, wordDict));
    }

}
