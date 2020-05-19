package algorithms;

import java.util.Arrays;

public class FindTheLongestSubstringContainingVowelsInEvenCounts {
    
    public int findTheLongestSubstring(String s) {
        int len = 0, vowelsBmp = 0, tmp = -1;
        int[] vowelsBmps = new int[1 << 5];
        Arrays.fill(vowelsBmps, -1);
        vowelsBmps[0] = 0;
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            switch (cs[i]) {
                case 'a':
                    vowelsBmp ^= 1;
                    break;
                case 'e':
                    vowelsBmp ^= 1 << 1;
                    break;
                case 'i':
                    vowelsBmp ^= 1 << 2;
                    break;
                case 'o':
                    vowelsBmp ^= 1 << 3;
                    break;
                case 'u':
                    vowelsBmp ^= 1 << 4;
                    break;
                default:
                    break;
            }
            if (vowelsBmps[vowelsBmp] > -1)
                len = Math.max(len, i - vowelsBmps[vowelsBmp]);
            else vowelsBmps[vowelsBmp] = i;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheLongestSubstringContainingVowelsInEvenCounts()
                .findTheLongestSubstring("eleetminicoworoep"));
    }

}
