package algorithms;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        loop: for (int asteroid : asteroids) {
            while (asteroid < 0 && !stack.isEmpty()) {
                int top = stack.peek();
                if (top < 0 || top > -asteroid)
                    break;
                if (stack.pop() == -asteroid)
                    continue loop;
            }
            if (asteroid > 0 || stack.isEmpty() || stack.peek() < 0)
                stack.push(asteroid);
        }
        return stack.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] asteroids = { -2, -2, 1, -2 };
        System.out.println(Arrays.toString(new AsteroidCollision().asteroidCollision(asteroids)));
    }

}
