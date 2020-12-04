package algorithms;

import java.util.HashMap;
import java.util.Map;

public class TaskScheduler {
    
    // method 1
    public int leastInterval1(char[] tasks, int n) {
        Map<Character, Integer> freq = new HashMap<>();
        // 最多的执行次数
        int maxExec = 0;
        for (char task : tasks) {
            int exec = freq.getOrDefault(task, 0) + 1;
            freq.put(task, exec);
            maxExec = Math.max(maxExec, exec);
        }
        // 具有最多执行次数的任务数量
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : freq.entrySet())
            if (entry.getValue() == maxExec)
                maxCount++;
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }
    
    // method 2 fastest
    public int leastInterval2(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        int[] counts = new int[26];
        for (char task : tasks)
            counts[task - 'A']++;
        int maxExec = 0, maxCount = 0;
        for (int count : counts)
            maxExec = Math.max(maxExec, count);
        for (int count : counts)
            if (count == maxExec)
                maxCount++;
        return Math.max((maxExec - 1) * (n + 1) + maxCount, tasks.length);
    }

    public static void main(String[] args) {
        char[] tasks = { 'A', 'A', 'A', 'A', 'B', 'B', 'B', 'C', 'C', 'D', 'D' };
        System.out.println(new TaskScheduler().leastInterval2(tasks, 2));
    }

}
