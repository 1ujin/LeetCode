package lcci;

import java.util.Arrays;

public class CircusTower {
    
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[] dp = new int[len + 1];
        int[][] hws = new int[len][2];
        for (int i = 0; i < hws.length; i++) {
            hws[i][0] = height[i];
            hws[i][1] = weight[i];
        }
        Arrays.sort(hws, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0;
        for (int[] hw : hws) {
            // 获取当前体重值在 dp 中的位置或者插入位置
            int i = Arrays.binarySearch(dp, 0, count, hw[1]);
            // 如果为负则说明是插入位置，在 dp 中不存在，转换为覆盖位置
            if (i < 0) i = -1 - i;
            // 如果覆盖位置在已有位置后一位，则说明是新增，数量自增
            if (count == i) count++;
            // 新的体重值较小则覆盖 dp 中稍大的值，新增说明大于前边所有的值
            dp[i] = hw[1];
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new CircusTower().bestSeqAtIndex(
                new int[] {65, 70, 56, 75, 60, 68},
                new int[] {100, 150, 90, 190, 95, 110}));
    }

}
