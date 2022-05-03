package algorithms;

import java.util.LinkedList;
import java.util.Queue;

public class FindTheWinnerOfTheCircularGame {

    // method 1
    public int findTheWinner1(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            queue.offer(i);
        while (queue.size() > 1) {
            for (int i = 1; i < k; i++)
                queue.offer(queue.poll());
            queue.poll();
        }
        return queue.peek();
    }

    // method 2
    public int findTheWinner2(int n, int k) {
        int winner = 1;
        for (int i = 2; i <= n; i++)
            winner = (k + winner - 1) % i + 1;
        return winner;
    }

    public static void main(String[] args) {
        System.out.println(new FindTheWinnerOfTheCircularGame()
                .findTheWinner2(5, 2));
    }

}
