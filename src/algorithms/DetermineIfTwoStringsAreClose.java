package algorithms;

public class DetermineIfTwoStringsAreClose {
    
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int[] count1 = new int[26], count2 = new int[26];
        for (char c : word1.toCharArray())
            count1[c - 'a']++;
        for (char c : word2.toCharArray())
            count2[c - 'a']++;
        for (int i = 0; i < 26; i++)
            if (count1[i] == 0 && count2[i] != 0 || count1[i] != 0 && count2[i] == 0)
                return false;
        for (int i : count1)
            for (int j = 0; j < 26; j++)
                if (i == count2[j])
                    count2[j] = 0;
        for (int i : count2)
            if (i != 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new DetermineIfTwoStringsAreClose().closeStrings("cabbba", "abbccc"));
    }

}
