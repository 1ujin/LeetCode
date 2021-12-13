package algorithms;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class CourseSchedule3 {

    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        int sum = 0;
        for (int[] course : courses) {
            int duration = course[0], lastDay = course[1];
            if (sum + duration <= lastDay) {
                sum += duration;
                queue.offer(duration);
            } else if (!queue.isEmpty() && queue.peek() > duration) {
                sum -= queue.poll();
                sum += duration;
                queue.offer(duration);
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] courses = { { 100, 200 }, { 200, 1300 }, { 1000, 1250 },
                { 2000, 3200 } };
        System.out.println(new CourseSchedule3().scheduleCourse(courses));
    }

}
