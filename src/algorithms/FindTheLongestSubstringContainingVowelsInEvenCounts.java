package algorithms;

import java.util.Arrays;

public class FindTheLongestSubstringContainingVowelsInEvenCounts {
    
    public int findTheLongestSubstring(String s) {
        int len = 0, vowelsBmp = 0;
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
            // 该元音奇偶状态第一次出现时，记录当前的位置
            if (vowelsBmps[vowelsBmp] == -1)
                vowelsBmps[vowelsBmp] = i + 1;
            // 再次出现该元音奇偶状态时，当前位置减去第一次出现时的位置
            // 同种奇偶状态的两个位置，中间的子串必为偶数状态，更新最大值
            else len = Math.max(len, i + 1 - vowelsBmps[vowelsBmp]);
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheLongestSubstringContainingVowelsInEvenCounts()
                .findTheLongestSubstring("eleetminicoworoep"));
    }

}
