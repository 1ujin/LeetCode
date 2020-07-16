package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {
    
    public boolean isBipartite(int[][] graph) {
        int[] vertices = new int[graph.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices.length; i++) {
            if (vertices[i] != 0) continue;
            queue.offer(i);
            vertices[i] = 1;
            while (!queue.isEmpty()) {
                int k = queue.poll();
                for (int j = 0; j < graph[k].length; j++) {
                    if (vertices[graph[k][j]] != 0 && vertices[k] == vertices[graph[k][j]])
                        return false;
                    else if (vertices[graph[k][j]] == 0) {
                        vertices[graph[k][j]] = -vertices[k];
                        queue.offer(graph[k][j]);
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = { { 1, 3 }, { 0, 2 }, { 1, 3 }, { 0, 2 } };
        System.out.println(new IsGraphBipartite().isBipartite(graph));
    }

}
