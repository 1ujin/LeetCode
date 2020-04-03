package lcci;

public class ReSpace {

    public int respace(String[] dictionary, String sentence) {
        int len = sentence.length();
        int[] dp = new int[len + 1];
        TrieNode trie = new TrieNode();
        for (String string : dictionary)
            trie.add(string);
        char[] cs = sentence.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            TrieNode node = trie;
            int j = i;
            while (j < cs.length && node.children[cs[j] - 'a'] != null) {
                node = node.children[cs[j++] - 'a'];
                if (node.isTail) dp[j] = Math.max(dp[j], dp[i] + j - i);
            }
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }
        return len - dp[len];
    }
    
    private class TrieNode {
        
        TrieNode[] children;
        boolean isTail;
        
        public TrieNode() {
            children = new TrieNode[26];
            isTail = false;
        }
        
        public void add(String s) {
            TrieNode node = this;
            for (char c : s.toCharArray()) {
                if (node.children[c - 'a'] == null)
                    node.children[c - 'a'] = new TrieNode();
                node = node.children[c - 'a'];
            }
            node.isTail = true;
        }
    }

    public static void main(String[] args) {
        String[] dictionary = { "looked", "just", "like", "her", "brother" };
        String sentence = "jesslookedjustliketimherbrother";
        System.out.println(new ReSpace().respace(dictionary, sentence));
    }

}
