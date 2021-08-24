package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AllPathsFromSourceToTarget {

    private int[][] graph;
    private List<List<Integer>> paths;
    private Stack<Integer> path;

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        this.graph = graph;
        paths = new ArrayList<>();
        path = new Stack<>();
        path.push(0);
        dfs(0);
        return paths;
    }

    private void dfs(int src) {
        if (src == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }
        for (int target : graph[src]) {
            path.push(target);
            dfs(target);
            path.pop();
        }
    }

    public static void main(String[] args) {
        int[][] graph = { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} };
        System.out.println(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph));
    }

}
