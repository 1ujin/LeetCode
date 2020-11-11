package algorithms;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray())
            count[c - 'a']++;
        int len = 0, res = 0;
        for (int i : count)
            if (i != 0)
                len++;
        int[] freqs = new int[len];
        for (int i = 0; i < 26; i++)
            if (count[i] != 0)
                freqs[--len] = count[i];
        len = freqs.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && freqs[j] != 0 && freqs[i] == freqs[j]) {
                    freqs[i]--;
                    res++;
                    j = -1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumDeletionsToMakeCharacterFrequenciesUnique()
                .minDeletions("aaabbbcc"));
    }

}
