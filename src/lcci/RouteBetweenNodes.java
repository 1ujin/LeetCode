package lcci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RouteBetweenNodes {
    
    // method 1 breadth-first search
    public boolean findWhetherExistsPath1(int n, int[][] graph, int start, int target) {
        @SuppressWarnings("unchecked")
        List<Integer>[] adjacencyLists = new List[n];
        for (int[] route : graph) {
            // 存储当前下标的数字作为起点时，邻接的所有点
            if (adjacencyLists[route[0]] == null) adjacencyLists[route[0]] = new ArrayList<>();
            adjacencyLists[route[0]].add(route[1]);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int currentStart = queue.poll();
            if (adjacencyLists[currentStart] == null) continue;
            if (adjacencyLists[currentStart].contains(target)) return true;
            for (Integer nextStart : adjacencyLists[currentStart]) queue.offer(nextStart);
        }
        return false;
    }
    
    // method 2 depth-first search
    public boolean findWhetherExistsPath2(int n, int[][] graph, int start, int target) {
        // 邻接表
        @SuppressWarnings("unchecked")
        List<Integer>[] adjacencyLists = new List[n];
        // 邻接矩阵
        // boolean[][] adjacencyMatrix = new boolean[n][n];
        for (int[] route : graph) {
            // 存储当前下标的数字作为起点时，邻接的所有点
            if (adjacencyLists[route[0]] == null) adjacencyLists[route[0]] = new ArrayList<>();
            adjacencyLists[route[0]].add(route[1]);
            // adjacencyMatrix[route[0]][route[1]] = true;
        }
        return dfs(adjacencyLists, start, target);
    }
    
    private boolean dfs(List<Integer>[] lists, int start, int target) {
        if (lists[start] != null)
            for (Integer i : lists[start])
                if (i == target || dfs(lists, i, target)) return true;
        return false;
    }
    
    // StackOverFlow
    @SuppressWarnings("unused")
    private boolean dfs(boolean[][] matrix, int start, int target) {
        if (matrix[start][target] == true) return true;
        for (int i = 0; i < matrix[start].length; i++)
            if (i != target && (matrix[start][i] == true || dfs(matrix, i, target))) return true;
        return false;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        boolean result = new RouteBetweenNodes().findWhetherExistsPath2(12, new int[][] {
            {0, 1}, {1, 2}, {1, 3}, {1, 10}, {1, 11}, {1, 4}, {2, 4}, {2, 6}, {2, 9}, {2, 10}, {2, 4}, {2, 5}, {2, 10}, 
            {3, 7}, {3, 7}, {4, 5}, {4, 11}, {4, 11}, {4, 10}, {5, 7}, {5, 10}, {6, 8}, {7, 11}, {8, 10}
        }, 2, 3);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
