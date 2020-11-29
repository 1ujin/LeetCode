package algorithms;

import java.util.Arrays;

public class ReorganizeString {
    
    public String reorganizeString(String S) {
        int[][] count = new int[26][2];
        for (int i = 0; i < 26; i++)
            count[i][0] = i + 'a';
        for (char c : S.toCharArray())
            count[c - 'a'][1]++;
        Arrays.sort(count, (a, b) -> b[1] < a[1] ? -1 : 1);
        int len = S.length(), i = 0, j = 0;
        if (count[0][1] > len + 1 >> 1) return "";
        char[] cs = new char[len];
        while (i < 26 && count[i][1] > 0) {
            cs[j] = (char) count[i][0];
            if (--count[i][1] == 0)
                i++;
            if ((j += 2) >= len)
                j = 1;
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(new ReorganizeString().reorganizeString("aab"));
    }

}
