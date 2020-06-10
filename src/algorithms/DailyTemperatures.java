package algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] result = new int[len];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            int t = T[i];
            while (!stack.isEmpty() && t > T[stack.peek()]) {
                int j = stack.pop();
                result[j] = i - j;
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] T = { 73, 74, 75, 71, 69, 72, 76, 73 };
        System.out.println(Arrays.toString(new DailyTemperatures().dailyTemperatures(T)));
    }

}
