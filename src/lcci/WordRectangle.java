package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordRectangle {

    public String[] maxRectangle(String[] words) {
        Map<Integer, TrieNode> trieMap = new HashMap<>();
        Map<String, List<String>> sameInitial = new HashMap<>();
        for (String word : words) {
            trieMap.compute(word.length(), (k, v) -> {
                if (v == null)
                    v = new TrieNode();
                v.add(word);
                return v;
            });
            sameInitial.compute(word, (k, v) -> {
                if (v == null)
                    v = new ArrayList<>();
                for (String s : words)
                    if (word.charAt(0) == s.charAt(0) && !sameInitial.containsKey(s))
                        v.add(s);
                return v;
            });
        }
        int max = 0;
        char[][] rectangle = null, maxRectangle = null;
        for (String key : sameInitial.keySet()) {
            int height = key.length();
            TrieNode colTrie = trieMap.get(height);
            outer: for (String row : sameInitial.get(key)) {
                int width = row.length();
                if (height * width <= max) continue;
                rectangle = new char[height][width];
                for (int i = 0; i < height; i++)
                    rectangle[i][0] = key.charAt(i);
                rectangle[0] = row.toCharArray();
                int i = 1;
                for (; i < height; i++) {
                    int j = 0;
                    for (; j < words.length; j++) {
                        if (words[j].length() == width && words[j].charAt(0) == rectangle[i][0]) {
                            rectangle[i] = words[j].toCharArray();
                            int k = 1;
                            inner: for (; k < width; k++) {
                                TrieNode check = colTrie.children[rectangle[0][k] - 'a'];
                                if (check == null) continue outer;
                                for (int l = 1; l <= i; l++) {
                                    if (check.children[rectangle[l][k] - 'a'] == null)
                                        break inner;
                                    else
                                        check = check.children[rectangle[l][k] - 'a'];
                                }
                            }
                            if (k == width) break;
                        }
                    }
                    if (j == words.length) break;
                }
                if (i != height) continue;
                max = height * width;
                maxRectangle = rectangle;
            }
        }
        return Arrays.stream(maxRectangle).map(String::valueOf)
                .toArray(String[]::new);
    }
    
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];

        public void add(String s) {
            TrieNode node = this;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
        }
        
        @Override
        public String toString() {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < 26; i++)
                if (children[i] != null)
                    list.add((char) ('a' + i));
            return list.toString();
        }
    }

    public static void main(String[] args) {
        String[] words = { "lcauj", "mdlby", "myulp", "yvkqn", "usajk", "rpj",
                "bojvf", "ukmkb", "afqbhs", "j", "ebe", "yacov", "wsaep", "zdk",
                "wziqrdd", "pcjfn", "nlrehaq", "dasrc", "lruvq", "dvca" };
        System.out.println(
                Arrays.toString(new WordRectangle().maxRectangle(words)));
    }

}
