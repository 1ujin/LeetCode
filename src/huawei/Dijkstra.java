package huawei;

import java.util.*;

public class Dijkstra {

    // 定义一个常量来表示没有路径
    private static final int INF = Integer.MAX_VALUE;

    // Dijkstra 算法实现，返回从 start 到 target 的最短路径
    public static int dijkstra(int[][] graph, int start, int target) {
        int n = graph.length;
        int[] dist = new int[n];  // 存储从起点到每个顶点的最短路径
        // boolean[] visited = new boolean[n];  // 标记顶点是否已被访问

        // 初始化距离数组，起点到自己的距离为 0，其他顶点为无穷大
        Arrays.fill(dist, INF);
        dist[start] = 0;
        Set<Integer> vertices = new HashSet<>();
        for (int i = 0; i < n; i++) {
            vertices.add(i);
        }

        // 使用优先队列（最小堆）来获取当前未访问的最短路径
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> dist[a]));
        pq.offer(start);

        while (!pq.isEmpty()) {
            // 取出当前最短路径的顶点
            // int[] current = pq.poll();
            // int v = current[0];
            // int sum = current[1];
            int v = pq.poll();
            int sum = dist[v];

            // 如果目标顶点已经访问过，且当前顶点是目标顶点，则可以返回结果
            // if (v == target)
            //     return sum;

            // 如果该顶点已经访问过，跳过
            // if (visited[v])
            if (!vertices.contains(v))
                continue;

            // 标记该顶点为已访问
            // visited[v] = true;
            vertices.remove(v);

            // 更新与当前顶点相邻的所有未访问顶点的最短路径
            // for (int u = 0; u < n; u++) {
            //     if (!visited[u] && graph[v][u] != INF) {
            //         int newDist = sum + graph[v][u];
            //         if (newDist < dist[u]) {
            //             dist[u] = newDist;
            //             pq.offer(u);
            //         }
            //     }
            // }
            for (int u : vertices) {
                if (graph[v][u] != INF) {
                    int newDist = sum + graph[v][u];
                    if (newDist < dist[u]) {
                        dist[u] = newDist;
                        pq.offer(u);
                    }
                }
            }
        }

        System.out.println(Arrays.toString(dist));

        // 如果没有路径到目标顶点，返回一个标识值（例如 -1 或 INF）
        return INF;
    }

    public static void main(String[] args) {
        // 示例图：二维数组表示有向图的权重矩阵
        // graph[i][j] 表示从顶点 i 到顶点 j 的边的权重，如果没有边则为 INF
        // int[][] graph = {
        //         {0, 10, INF, INF, INF, 30, 100},
        //         {INF, 0, 50, INF, INF, INF, INF},
        //         {INF, INF, 0, 20, INF, INF, INF},
        //         {INF, INF, INF, 0, 10, 60, INF},
        //         {INF, INF, INF, INF, 0, INF, 50},
        //         {INF, INF, INF, INF, INF, 0, 10},
        //         {INF, INF, INF, INF, INF, INF, 0}
        // };
        int[][] graph = {
                {0, 1, 3, INF, INF, INF},
                {INF, 0, 1, 4, 2, INF},
                {INF, INF, 0, 5, 5, INF},
                {INF, INF, INF, 0, INF, 3},
                {INF, INF, INF, 1, 0, 6},
                {INF, INF, INF, INF, INF, 0},
        };
        // int[][] graph = {
        //         {0, 1, 10, INF},
        //         {INF, 0, INF, 100},
        //         {INF, INF, 0, 10},
        //         {INF, INF, INF, 0}
        // };

        int startVertex = 0;  // 起始顶点
        int targetVertex = 5;  // 目标顶点

        int shortestPath = dijkstra(graph, startVertex, targetVertex);

        // 输出从顶点 startVertex 到顶点 targetVertex 的最短路径
        // if (shortestPath == INF) {
        //     System.out.println("从顶点 " + startVertex + " 到顶点 " + targetVertex + " 没有路径");
        // } else {
        //     System.out.println("从顶点 " + startVertex + " 到顶点 " + targetVertex + " 的最短路径是: " + shortestPath);
        // }
    }
}
