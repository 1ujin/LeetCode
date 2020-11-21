package algorithms;

public class ValidAnagram {
    
    public boolean isAnagram(String s, String t) {
        char[] cs1 = s.toCharArray(), cs2 = t.toCharArray();
        if (cs1.length != cs2.length) return false;
        int[] count = new int[26];
        for (int i = 0; i < cs1.length; i++) {
            count[cs1[i] - 'a']++;
            count[cs2[i] - 'a']--;
        }
        for (int i : count)
            if (i != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("anagram", "nagaram"));
    }

}
