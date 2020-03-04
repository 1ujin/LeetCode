package lcci;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RouteBetweenNodes {
    
    // method 1 breadth-first search
    public boolean findWhetherExistsPath1(int n, int[][] graph, int start, int target) {
        List<Integer>[] adjacencyLists = new List[n];
        for (int[] route : graph) {
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
        return false;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        boolean result = new RouteBetweenNodes().findWhetherExistsPath1(3, new int[][] {
            {0, 1}, {0, 2}, {1, 2}, {1, 2}
        }, 0, 2);
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
