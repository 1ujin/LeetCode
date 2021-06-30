package lcp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class LCP07 {

    private Map<Integer, List<Integer>> map = new HashMap<>();

    // method 1 graph depth-first search
    private int n, k, count;

    public int numWays1(int n, int[][] relation, int k) {
        this.n = n;
        this.k = k;
        for (int[] edge : relation) {
            map.compute(edge[0], (key, v) -> {
                if (v == null)
                    v = new ArrayList<>();
                v.add(edge[1]);
                return v;
            });
        }
        dfs(0, 0);
        return count;
    }

    private void dfs(int index, int step) {
        if (step >= k) {
            if (index == n - 1)
                count++;
            return;
        }
        for (int next : map.getOrDefault(index, new ArrayList<>()))
            dfs(next, step + 1);
    }

    // method 2 graph breadth-first search
    public int numWays2(int n, int[][] relation, int k) {
        for (int[] edge : relation) {
            map.compute(edge[0], (key, v) -> {
                if (v == null)
                    v = new ArrayList<>();
                v.add(edge[1]);
                return v;
            });
        }
        int step = 0, count = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty() && step < k) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int source = queue.poll();
                if (map.containsKey(source))
                    queue.addAll(map.get(source));
            }
        }
        if (step == k)
            for (int target : queue)
                count += target == n - 1 ? 1 : 0;
        return count;
    }

    // method 3 dynamic programming fastest
    public int numWays3(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++)
            for (int[] edge : relation)
                dp[i + 1][edge[1]] += dp[i][edge[0]];
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        int[][] relation = { { 0, 2 }, { 2, 1 }, { 3, 4 }, { 2, 3 }, { 1, 4 },
                { 2, 0 }, { 0, 4 } };
        System.out.println(new LCP07().numWays3(5, relation, 3));
    }

}
