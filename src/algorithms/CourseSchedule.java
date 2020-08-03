package algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    
    List<List<Integer>> adjacencyList;
    
    // method 1 depth-first search
    boolean[] visited;

    public boolean canFinish1(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        visited = new boolean[numCourses];
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacencyList.add(new ArrayList<>());
        for (int[] prerequisite : prerequisites)
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        for (int i = 0; i < numCourses; i++)
            if (!dfs(i))
                return false;
        return true;
    }

    private boolean dfs(int i) {
        if (visited[i]) return false;
        visited[i] = true;
        for (Integer next : adjacencyList.get(i))
            if (!dfs(next))
                return false;
        visited[i] = false;
        return true;
    }
    
    // method 2 breadth-first search
    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        if (numCourses == 0) return true;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacencyList.add(new ArrayList<>());
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++)
            if (indegrees[i] == 0)
                queue.offer(i);
        while (!queue.isEmpty()) {
            numCourses--;
            for (Integer i : adjacencyList.get(queue.poll()))
                if (--indegrees[i] == 0)
                    queue.offer(i);
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int[][] prerequisites = { { 1, 0 } };
        System.out.println(new CourseSchedule().canFinish2(2, prerequisites));
    }

}
