package algorithms;

import java.util.Arrays;

public class RelativeRanks {

    public String[] findRelativeRanks(int[] score) {
        int len = score.length;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = score[i];
            arr[i][1] = i;
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] rank = new String[len];
        for (int i = 0; i < len; i++) {
            if (i == 0)
                rank[arr[i][1]] = "Gold Medal";
            else if (i == 1)
                rank[arr[i][1]] = "Silver Medal";
            else if (i == 2)
                rank[arr[i][1]] = "Bronze Medal";
            else
                rank[arr[i][1]] = String.valueOf(i + 1);
        }
        return rank;
    }

    public static void main(String[] args) {
        int[] score = { 10, 3, 8, 9, 4 };
        System.out.println(Arrays.toString(new RelativeRanks().findRelativeRanks(score)));
    }

}
