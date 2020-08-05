package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindromePairs {
    
    private class Node {
        int[] ch = new int[26];
        int flag = -1;
    }
    
    List<Node> trie = new ArrayList<>();
    
    public List<List<Integer>> palindromePairs(String[] words) {
        trie.add(new Node());
        int len = words.length;
        for (int i = 0; i < len; i++)
            insert(words[i], i);
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int m = words[i].length();
            for (int j = 0; j <= m; j++) {
                if (isPalindrome(words[i], j, m - 1)) {
                    int left = findWord(words[i], 0, j - 1);
                    if (left != -1 && left != i)
                        ret.add(Arrays.asList(i, left));
                }
                if (j != 0 && isPalindrome(words[i], 0, j - 1)) {
                    int right = findWord(words[i], j, m - 1);
                    if (right != -1 && right != i)
                        ret.add(Arrays.asList(right, i));
                }
            }
        }
        return ret;
    }

    private void insert(String s, int id) {
        int len = s.length(), add = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i) - 'a';
            if (trie.get(add).ch[x] == 0) {
                trie.add(new Node());
                trie.get(add).ch[x] = trie.size() - 1;
            }
            add = trie.get(add).ch[x];
        }
        trie.get(add).flag = id;
    }
    
    private boolean isPalindrome(String s, int begin, int end) {
        int len = end - begin + 1;
        for (int i = 0; i < len >> 1; i++)
            if (s.charAt(begin + i) != s.charAt(end - i))
                return false;
        return true;
    }
    
    private int findWord(String s, int begin, int end) {
        int add = 0;
        for (int i = end; i >= begin; i--) {
            int x = s.charAt(i) - 'a';
            if (trie.get(add).ch[x] == 0)
                return -1;
            add = trie.get(add).ch[x];
        }
        return trie.get(add).flag;
    }

    public static void main(String[] args) {
        String[] words = { "abcd", "dcba", "lls", "s", "sssll" };
        System.out.println(new PalindromePairs().palindromePairs(words));
    }

}
