package algorithms;

import java.util.Arrays;

public class XOfAKindInADeckOfCards {
    
    public boolean hasGroupsSizeX(int[] deck) {
        int[] count = new int[10000];
        for (int i : deck) count[i]++;
//        int x = 0;
//        for (int count : counts) {
//            if (count > 0) {
//                x = x == 0 ? count : gcd(x, count);
//                if (x == 1) return false;
//            }
//        }
//        return x > 1;
        return Arrays.stream(count).reduce(this::gcd).getAsInt() > 1;
    }
    
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        System.out.println(new XOfAKindInADeckOfCards().
                hasGroupsSizeX(new int[] {1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }

}
