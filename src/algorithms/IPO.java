package algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class IPO {

    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int len = profits.length, index = 0;
        int[][] arr = new int[len][2];
        for (int i = 0; i < len; i++) {
            arr[i][0] = capital[i];
            arr[i][1] = profits[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < k; i++) {
            while (index < len && w >= arr[index][0])
                queue.offer(arr[index++][1]);
            if (!queue.isEmpty())
                w += queue.poll();
            else break;
        }
        return w;
    }

    public static void main(String[] args) {
        int[] profits = { 1, 2, 3 }, capital = { 0, 1, 1 };
        System.out.println(new IPO().findMaximizedCapital(2, 0, profits, capital));
    }

}
