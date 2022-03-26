package algorithms;

import java.util.Arrays;

public class FindMissingOservations {

    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = mean * (rolls.length + n);
        for (int roll : rolls)
            sum -= roll;
        if (sum < n || sum > 6 * n)
            return new int[0];
        int quotient = sum / n, remainder = sum % n;
        int[] missing = new int[n];
        for (int i = 0; i < n; i++) {
            if (i < remainder)
                missing[i] = quotient + 1;
            else
                missing[i] = quotient;
        }
        return missing;
    }

    public static void main(String[] args) {
        int[] rolls = { 3, 2, 4, 3 };
        System.out.println(Arrays.toString(new FindMissingOservations()
                .missingRolls(rolls, 4, 2)));
    }

}
