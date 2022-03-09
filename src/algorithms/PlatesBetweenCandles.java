package algorithms;

import java.util.Arrays;

public class PlatesBetweenCandles {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        int[] preSum = new int[len], lefts = new int[len],
                rights = new int[len], result = new int[queries.length];
        if (cs[0] == '*')
            preSum[0] = 1;
        for (int i = 1; i < len; i++)
            preSum[i] = preSum[i - 1] + (cs[i] == '*' ? 1 : 0);
        if (cs[0] != '|')
            lefts[0] = -1;
        for (int i = 1; i < len; i++)
            lefts[i] = cs[i] == '|' ? i : lefts[i - 1];
        if (cs[len - 1] != '|')
            rights[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--)
            rights[i] = cs[i] == '|' ? i : rights[i + 1];
        for (int i = 0; i < queries.length; i++) {
            int left = lefts[queries[i][1]], right = rights[queries[i][0]];
            result[i] = left == -1 || right == -1 || right >= left ? 0
                    : preSum[left] - preSum[right];
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] queries = { { 1, 17 }, { 4, 5 }, { 14, 17 }, { 5, 11 },
                { 15, 16 } };
        System.out.println(Arrays.toString(new PlatesBetweenCandles()
                .platesBetweenCandles("***|**|*****|**||**|*", queries)));
    }

}
