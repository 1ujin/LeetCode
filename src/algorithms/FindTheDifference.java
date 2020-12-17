package algorithms;

public class FindTheDifference {
    
    public char findTheDifference(String s, String t) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        for (char c : t.toCharArray())
            count[c - 'a']--;
        for (int i = 0; i < 26; i++)
            if (count[i] == -1)
                return (char) ('a' + i);
        return 'a';
    }

    public static void main(String[] args) {
        System.out.println(new FindTheDifference().findTheDifference("abcd", "abcde"));
    }

}
