package algorithms;

public class VerifyingAnAlienDictionary {

    public boolean isAlienSorted(String[] words, String order) {
        int[] dict = new int[26];
        char[] cs = order.toCharArray();
        for (int i = 0; i < 26; i++)
            dict[cs[i] - 'a'] = i;
        char[][] css = new char[words.length][0];
        for (int i = 0; i < words.length; i++)
            css[i] = words[i].toCharArray();
        loop: for (int i = 1; i < words.length; i++) {
            int len = Math.min(css[i - 1].length, css[i].length);
            for (int j = 0; j < len; j++) {
                int a = dict[css[i - 1][j] - 'a'], b = dict[css[i][j] - 'a'];
                if (a > b)
                    return false;
                if (a < b)
                    continue loop;
            }
            if (css[i - 1].length > css[i].length)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = { "hello", "leetcode" };
        String order = "hlabcdefgijkmnopqrstuvwxyz";
        System.out.println(new VerifyingAnAlienDictionary().isAlienSorted(words, order));
    }

}
