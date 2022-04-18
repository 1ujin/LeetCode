package algorithms;

import java.util.Arrays;

public class ShortestDistanceToACharacter {

    public int[] shortestToChar(String s, char c) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int[] dist = new int[len];
        for (int i = 0, j = 1; i < len; i++, j = 1) {
            if (cs[i] == c)
                continue;
            int min = Math.min(i, len - i);
            for (; j < min; j++) {
                if (cs[i - j] == c || cs[i + j] == c) {
                    dist[i] = j;
                    break;
                }
            }
            if (dist[i] != 0)
                continue;
            for (; j < len; j++) {
                if (i + j < len && cs[i + j] == c
                        || i - j >= 0 && cs[i - j] == c) {
                    dist[i] = j;
                    break;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ShortestDistanceToACharacter()
                .shortestToChar("loveleetcode", 'e')));
    }

}
