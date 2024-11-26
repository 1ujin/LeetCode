package huawei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 分批萨
 */
public class OD374 {

    private static int[][] memo;
    private static int max;
    private static int[] pizza;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();
        scanner.close();
        System.out.println(solution2(arr));
    }

    private static int solution1(int[] pizza) {
        int n = pizza.length;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                deque.add(pizza[j]);
            for (int j = 0; j < i; j++)
                deque.add(pizza[j]);
            recur1(deque, pizza[i]);
            deque.clear();
        }
        return max;
    }

    private static void recur1(Deque<Integer> deque, int sum) {
        if (deque.isEmpty()) {
            max = Math.max(max, sum);
            return;
        }
        int rm = deque.peekFirst() > deque.peekLast() ? deque.pollFirst() : -deque.pollLast();
        int first = deque.removeFirst();
        recur1(deque, sum + first);
        deque.offerFirst(first);
        int last = deque.removeLast();
        recur1(deque, sum + last);
        deque.offerLast(last);
        if (rm > 0)
            deque.offerFirst(rm);
        else
            deque.offerLast(rm);
    }

    private static int solution2(int[] pizza) {
        int n = pizza.length;
        OD374.pizza = pizza;
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            max = Math.max(max, recur2(i - 1, i + 1) + pizza[i]);
        }
        return max;
    }

    private static int recur2(int i, int j) {
        int n = pizza.length;
        i = Math.floorMod(i, n);
        j = Math.floorMod(j, n);
        if (pizza[i] > pizza[j])
            i = Math.floorMod(i - 1, n);
        else
            j = Math.floorMod(j + 1, n);
        if (memo[i][j] > 0)
            return memo[i][j];
        if (i == j)
            memo[i][j] = pizza[i];
        else
            memo[i][j] = Math.max(recur2(i - 1, j) + pizza[i], recur2(i, j+ 1) + pizza[j]);
        return memo[i][j];
    }
}
