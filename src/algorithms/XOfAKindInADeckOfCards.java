package algorithms;

import java.util.Arrays;

public class XOfAKindInADeckOfCards {
    
    public boolean hasGroupsSizeX(int[] deck) {
        int[] counts = new int[10000];
        for (int i : deck) counts[i]++;
//        boolean foundAny = false;
//        int x = 0;
//        for (int count : counts) {
//            if (!foundAny) {
//                foundAny = true;
//                x = count;
//            } else x = gcd(x, count);
//        }
//        return x > 1;
        return Arrays.stream(counts).reduce(this::gcd).getAsInt() > 1; // java 8
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new XOfAKindInADeckOfCards().
                hasGroupsSizeX(new int[] {1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }

}
