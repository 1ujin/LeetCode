package algorithms;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int min = citations[0], max = citations[citations.length - 1], h = 0;
        int[] counts = new int[max - min + 2];
        for (int citation : citations)
            counts[citation - min]++;
        for (int i = max - min; i >= 0; i--)
            if ((counts[i] += counts[i + 1]) > h && min + i > h)
                h = Math.min(counts[i], min + i);
        return h;
    }

    public static void main(String[] args) {
        int[] citations = { 3, 0, 6, 1, 5 };
        System.out.println(new HIndex().hIndex(citations));
    }

}
