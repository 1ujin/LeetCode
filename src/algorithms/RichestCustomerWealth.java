package algorithms;

import java.util.Arrays;

public class RichestCustomerWealth {

    // method 1 fastest
    public int maximumWealth1(int[][] accounts) {
        int max = 0;
        for (int[] account : accounts) {
            int sum = 0;
            for (int a : account)
                sum += a;
            max = Math.max(max, sum);
        }
        return max;
    }

    // method 2 shortest
    public int maximumWealth2(int[][] accounts) {
        return Arrays.stream(Arrays.stream(accounts)
                .max((a, b) -> Arrays.stream(a).sum() - Arrays.stream(b).sum())
                .get()).sum();
    }

    public static void main(String[] args) {
        int[][] accounts = { { 2, 8, 7 }, { 7, 1, 3 }, { 1, 9, 5 } };
        System.out.println(new RichestCustomerWealth().maximumWealth2(accounts));
    }

}
