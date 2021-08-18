package algorithms;

public class ReverseVowelsOfAString {

    private static final char[] VOWELS = { 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u' };

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            while (i < j && !isVowel(cs[i]))
                i++;
            while (i < j && !isVowel(cs[j]))
                j--;
            char c = cs[i];
            cs[i++] = cs[j];
            cs[j--] = c;
        }
        return String.valueOf(cs);
    }

    private boolean isVowel(char c) {
        for (char vowel : VOWELS)
            if (vowel == c)
                return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("leetcode"));
    }

}
