package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ShortEncodingOfWords {
    
    // method 1 set and override comparator of string length
    public int minimumLengthEncoding1(String[] words) {
        int len = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Set<String> set = new HashSet<>();
        for (String word : words) {
            boolean sign = set.add(word);
            if (!sign) System.out.println(word);
            len += sign ? word.length() + 1 : 0;
            for (int i = 1; i < word.length(); i++)
                len -= set.remove(word.substring(i)) ? word.length() - i + 1 : 0;
        }
        return len;
    }
    
    // method 2 override comparator of string prefix
    public int minimumLengthEncoding2(String[] words) {
        int len = 0;
        Arrays.sort(words, (a, b) -> new StringBuilder(a).reverse().
                compareTo(new StringBuilder(b).reverse()));
        for (int i = 0; i < words.length - 1; i++)
            if (!words[i + 1].startsWith(words[i]))
                len += words[i].length() + 1;
        len += words[words.length - 1].length() + 1;
        return len;
    }
    
    // method 3 trie fastest
    public int minimumLengthEncoding3(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, String> map = new HashMap<>();
        for (String word : words) {
            TrieNode node = trie;
            for (int i = word.length() - 1; i > -1; i--)
                node = node.get(word.charAt(i));
            map.put(node, word);
        }
        int len = 0;
        for (TrieNode node : map.keySet())
            if (node.count == 0)
                len += map.get(node).length() + 1;
        return len;
    }

    private class TrieNode {
        
        TrieNode[] children;
        int count;
        
        public TrieNode() {
            children = new TrieNode[26];
            count = 0;
        }
        
        public TrieNode get(char c) {
            if (children[c - 'a'] == null) {
                children[c - 'a'] = new TrieNode();
                count++;
            }
            return children[c - 'a'];
        }
    }
    
    public static void main(String[] args) {
        System.out.println(new ShortEncodingOfWords().
                minimumLengthEncoding3(new String[] {"time", "me", "bell"}));
    }

}
