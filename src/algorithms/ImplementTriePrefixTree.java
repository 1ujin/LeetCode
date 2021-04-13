package algorithms;

class Trie {
    private Trie[] children;
    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trie.children[index] == null)
                trie.children[index] = new Trie();
            trie = trie.children[index];
        }
        trie.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (trie.children[index] == null)
                return false;
            trie = trie.children[index];
        }
        return trie.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (trie.children[index] == null)
                return false;
            trie = trie.children[index];
        }
        return true;
    }
}

public class ImplementTriePrefixTree {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

}
