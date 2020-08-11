package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
    
    // Definition for a Node.
    @SuppressWarnings("unused")
    private class Node {
        public int val;
        public List<Node> neighbors;
        
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    
    // method 1 breadth-first search
    public Node cloneGraph1(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>(); 
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node.val, new Node(node.val));
        while (!queue.isEmpty()) {
            Node pollNode = queue.poll();
            for (Node neighbor : pollNode.neighbors) {
                if (!map.containsKey(neighbor.val)) {
                    map.put(neighbor.val, new Node(neighbor.val));
                    queue.offer(neighbor);
                }
                map.get(pollNode.val).neighbors.add(map.get(neighbor.val));
            }
        }
        return map.get(node.val);
    }
    
    // method 2 depth-first search
    Map<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph2(Node node) {
        if (node == null) return null;
        if (map.containsKey(node.val))
            return map.get(node.val);
        Node cloneNode = new Node(node.val);
        map.put(node.val, cloneNode);
        for (Node neighbor : node.neighbors)
            cloneNode.neighbors.add(cloneGraph2(neighbor));
        return cloneNode;
    }

    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();
        Node node1 = cg.new Node(1);
        Node node2 = cg.new Node(2);
        Node node3 = cg.new Node(3);
        Node node4 = cg.new Node(4);
        node1.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node1, node3);
        Node node = cg.cloneGraph2(node1);
        System.out.println(Arrays.deepToString(new int[][] {
            node.neighbors.stream().mapToInt(n -> n.val).toArray(),
            node.neighbors.get(0).neighbors.stream().mapToInt(n -> n.val).toArray(),
            node.neighbors.get(0).neighbors.get(1).neighbors.stream().mapToInt(n -> n.val).toArray(),
            node.neighbors.get(1).neighbors.stream().mapToInt(n -> n.val).toArray(),
        }));
    }

}
