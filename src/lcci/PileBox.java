package lcci;

import java.util.Arrays;

public class PileBox {
    
    public int pileBox(int[][] box) {
        // 宽度升序 > 深度降序 > 高度降序
        Arrays.sort(box, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? b[2] - a[2] : b[1] - a[1] : a[0] - b[0]);
        int max = 0, len = box.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i++) {
            int tmp = 0;
            for (int j = 0; j < i; j++)
                if (box[j][1] < box[i][1] && box[j][2] < box[i][2])
                    tmp = tmp > dp[j] ? tmp : dp[j];
            dp[i] = tmp + box[i][2];
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }
    
    // time limit exceeded
    public int pileBoxTLE(int[][] box) {
        return backtrack(box, box.length - 1, box[box.length - 1][2]);
    }
    
    private int backtrack(int[][] box, int index, int max) {
        if (index == 0) return max;
        int branch = 0;
        for (int i = index - 1; i > -1; i--)
            if (box[index][0] <= box[i][0] || box[index][1] <= box[i][1]) {
                int tmp = backtrack(box, i, 1);
                branch = branch > tmp ? branch : tmp;
            } else {
                index = i;
                max += box[i][2];
            }
        return max > branch ? max : branch; 
    }

    public static void main(String[] args) {
        System.out.println(new PileBox().pileBox(new int[][] {
            {1, 1, 1}, {2, 3, 4}, {2, 6, 7}, {3, 4, 5}
        }));
    }

}
