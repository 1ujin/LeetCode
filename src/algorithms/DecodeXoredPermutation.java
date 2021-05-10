package algorithms;

import java.util.Arrays;

public class DecodeXoredPermutation {
    
    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] perm = new int[n];
        for (int i = 1; i <= n; i++)
            perm[0] ^= i;
        for (int i = 1; i < n - 1; i += 2)
            perm[0] ^= encoded[i];
        for (int i = 1; i < n; i++)
            perm[i] = perm[i - 1] ^ encoded[i - 1];
        return perm;
    }

    public static void main(String[] args) {
        int[] encoded = { 6, 5, 4, 6 };
        System.out.println(Arrays.toString(new DecodeXoredPermutation().decode(encoded)));
    }

}
