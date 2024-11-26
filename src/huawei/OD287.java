package huawei;

import java.util.*;
import java.util.stream.Collectors;

/**
 * boss 的收入
 */
public class OD287 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 3; j++)
                arr[i][j] = scanner.nextInt();
        scanner.close();
        // int[][] arr = new int[0xffff][3];
        // for (int i = 0; i < 0xffff; i++) {
        //     arr[i] = new int[]{i + 1, i, 200};
        // }
        System.out.println(bfs(arr));
    }

    // dfs
    private static String solution(int[][] arr) {
        Map<Integer, Map<Integer, Integer>> edges = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] a : arr) {
            int id = a[0], parent = a[1], income = a[2];
            children.add(id);
            if (!edges.containsKey(parent))
                edges.put(parent, new HashMap<>());
            edges.get(parent).put(id, income);
        }
        int root = -1;
        for (Integer id : edges.keySet())
            if (!children.contains(id))
                root = id;
        return root + " " + dfs(edges, root);
    }

    private static int dfs(Map<Integer, Map<Integer, Integer>> edges, int id) {
        if (!edges.containsKey(id))
            return 0;
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : edges.get(id).entrySet())
            sum += (dfs(edges, entry.getKey()) + entry.getValue()) / 100 * 15;
        return sum;
    }

    // bfs
    private static String bfs(int[][] arr) {
        Map<Integer, Integer> edges = new HashMap<>();
        Map<Integer, Integer> incomes = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        for (int[] a : arr) {
            int id = a[0], parent = a[1], income = a[2];
            incomes.put(id, income);
            edges.put(id, parent);
            if (!inDegree.containsKey(id))
                inDegree.put(id, 0);
            inDegree.put(parent, inDegree.getOrDefault(parent, 0) + 1);
        }
        Queue<Integer> leaves = inDegree.entrySet().stream().filter(e -> e.getValue() == 0).map(Map.Entry::getKey).collect(Collectors.toCollection(LinkedList::new));
        int root = -1;
        while (!leaves.isEmpty()) {
            root = leaves.poll();
            if (!edges.containsKey(root))
                continue;
            int parent = edges.get(root);
            incomes.put(parent, incomes.getOrDefault(parent, 0) + incomes.get(root) / 100 * 15);
            inDegree.put(parent, inDegree.get(parent) - 1);
            if (inDegree.get(parent) == 0)
                leaves.offer(parent);
        }
        return root + " " + incomes.get(root);
    }
}
