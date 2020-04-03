package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MultiSearch {
    
    // method 1
    public int[][] multiSearch1(String big, String[] smalls) {
        int[][] result = new int[smalls.length][];
        for (int i = 0; i < smalls.length; i++) {
            String small = smalls[i];
            List<Integer> t = new ArrayList<>();
            int index = 0;
            while (small.length() != 0 && index < big.length()) {
                int tmp = big.indexOf(small, index);
                if (tmp < 0) break;
                if (tmp == index) t.add(index);
                index++;
            }
            result[i] = t.stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }
    
    // method 2 trie
    public int[][] multiSearch2(String big, String[] smalls) {
        int len = smalls.length;
        TrieNode trie = new TrieNode();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            trie.add(smalls[i], i);
            list.add(new ArrayList<>());
        }
        char[] cs = big.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            TrieNode node = trie;
            for (int j = i; j < cs.length; j++) {
                if (node.children[cs[j] - 'a'] == null) break;
                node = node.children[cs[j] - 'a'];
                if (node.index > -1)
                    list.get(node.index).add(i);
            }
        }
        int[][] res = new int[len][];
        for (int i = 0; i < len; i++)
            res[i] = list.get(i).stream().mapToInt(Integer::intValue).toArray();
        return res;
    }
    
    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int index = -1;

        public void add(String s, int index) {
            TrieNode node = this;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.index = index;
        }
    }

    public static void main(String[] args) {
        int[][] result = new MultiSearch().multiSearch2("mississippi",
                new String[] { "is", "ppi", "hi", "sis", "i", "ssippi" });
        System.out.println(Arrays.toString(Arrays.asList(result).stream()
                .map(s -> Arrays.toString(s)).toArray()));
    }

}
