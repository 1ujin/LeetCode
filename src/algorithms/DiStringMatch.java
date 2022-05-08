package algorithms;

import java.util.Arrays;

public class DiStringMatch {

    public int[] diStringMatch(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length, lo = 0, hi = len;
        int[] perm = new int[len + 1];
        for (int i = 0; i < len; i++)
            perm[i] = cs[i] == 'I' ? lo++ : hi--;
        perm[len] = lo;
        return perm;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new DiStringMatch()
                .diStringMatch("IDID")));
    }

}
