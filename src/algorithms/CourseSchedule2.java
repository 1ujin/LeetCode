package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule2 {

    // method 1 breadth-first search
    public int[] findOrder1(int numCourses, int[][] prerequisites) {
        int[] schedule = new int[numCourses];
        if (numCourses == 0) return schedule;
        int[] indegrees = new int[numCourses];
        for (int[] prerequisite : prerequisites)
            indegrees[prerequisite[0]]++;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++)
            if (indegrees[i] == 0)
                queue.offer(i);
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            schedule[count++] = course;
            for (int[] prerequisite : prerequisites)
                if (prerequisite[1] == course)
                    if (--indegrees[prerequisite[0]] == 0)
                        queue.offer(prerequisite[0]);
        }
        return count == numCourses ? schedule : new int[0];
    }
    
    // method 2 breadth-first search
    public int[] findOrder2(int numCourses, int[][] prerequisites) {
        int[] schedule = new int[numCourses];
        if (numCourses == 0) return schedule;
        int[] indegrees = new int[numCourses];
        @SuppressWarnings("unchecked")
        List<Integer>[] adjacencyList = new List[numCourses];
        for (int i = 0; i < numCourses; i++)
            adjacencyList[i] = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacencyList[prerequisite[1]].add(prerequisite[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < indegrees.length; i++)
            if (indegrees[i] == 0)
                queue.offer(i);
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            schedule[count++] = course;
            for (int i : adjacencyList[course])
                if (--indegrees[i] == 0)
                    queue.offer(i);
        }
        return count == numCourses ? schedule : new int[0];
    }
    
    // method 3 depth-first search fastest
    List<Integer>[] adjacencyList;
    int[] schedule, indegrees;
    int count;
    
    @SuppressWarnings("unchecked")
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        schedule = new int[numCourses];
        if (numCourses == 0) return schedule;
        indegrees = new int[numCourses];
        adjacencyList = new List[numCourses];
        for (int i = 0; i < numCourses; i++)
            adjacencyList[i] = new ArrayList<>();
        for (int[] prerequisite : prerequisites) {
            indegrees[prerequisite[0]]++;
            adjacencyList[prerequisite[1]].add(prerequisite[0]);
        }
        for (int course = 0; course < numCourses; course++)
            if (indegrees[course] == 0) {
                schedule[count++] = course;
                dfs(course);
            }
        return count == numCourses ? schedule : new int[0];
    }

    private void dfs(int i) {
        indegrees[i]--;
        for (int course : adjacencyList[i])
            if (--indegrees[course] == 0) {
                schedule[count++] = course;
                dfs(course);
            }
    }

    public static void main(String[] args) {
        int[][] prerequisites = { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
        System.out.println(Arrays.toString(new CourseSchedule2().findOrder(4, prerequisites)));
    }

}
