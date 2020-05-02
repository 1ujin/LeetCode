package lcof;

public class Solution58II {
    
    public String reverseLeftWords(String s, int n) {
        return s.substring(n).concat(s.substring(0, n));
    }

    public static void main(String[] args) {
        System.out.println(new Solution58II().reverseLeftWords("abcdefg", 2));
    }

}
