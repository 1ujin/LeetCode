package algorithms;

import java.util.Arrays;

public class SortCharactersByFrequency {
    
    public String frequencySort(String s) {
        int[][] counts = new int[255][2];
        for (int i = 0; i < 255; i++)
            counts[i][0] = i;
        for (char c : s.toCharArray())
            counts[c][1]++;
        Arrays.sort(counts, (a, b) -> b[1] - a[1]);
        char[] cs = new char[s.length()];
        int index = 0;
        for (int[] count : counts)
            for (int i = 0; i < count[1]; i++)
                cs[index++] = (char) (count[0]);
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(new SortCharactersByFrequency().frequencySort("cccaabadb"));
    }

}
