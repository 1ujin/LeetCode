package algorithms;

import java.util.Arrays;

public class NetworkDelayTime {
    
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] delays = new int[n];
        int[][] graph = new int[n][n];
        boolean[] visited = new boolean[n];
        Arrays.fill(delays, -1 >>> 1);
        delays[k - 1] = 0;
        for (int[] row : graph)
            Arrays.fill(row, -1 >>> 1);
        for (int[] time : times)
            graph[time[0] - 1][time[1] - 1] = time[2];
        while (true) {
            int index = -1, min = -1 >>> 1;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && min > delays[i]) {
                    index = i;
                    min = delays[i];
                }
            }
            if (index == -1)
                break;
            visited[index] = true;
            for (int i = 0; i < n; i++)
                if (!visited[i] && graph[index][i] != -1 >>> 1)
                    delays[i] = Math.min(delays[i], min + graph[index][i]);
        }
        int delay = -1;
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                return -1;
            delay = delay > delays[i] ? delay : delays[i];
        }
        return delay;
    }

    public static void main(String[] args) {
        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        System.out.println(new NetworkDelayTime().networkDelayTime(times, 4, 2));
    }

}
