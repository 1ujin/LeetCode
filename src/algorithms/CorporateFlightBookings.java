package algorithms;

import java.util.Arrays;

public class CorporateFlightBookings {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] nums = new int[n];
        for (int[] booking : bookings) {
            nums[booking[0] - 1] += booking[2];
            if (booking[1] < n)
                nums[booking[1]] -= booking[2];
        }
        for (int i = 1; i < n; i++)
            nums[i] += nums[i - 1];
        return nums;
    }

    public static void main(String[] args) {
        int[][] bookings = { { 1, 2, 10 }, { 2, 3, 20 }, { 2, 5, 25 } };
        System.out.println(Arrays.toString(new CorporateFlightBookings().corpFlightBookings(bookings, 5)));
    }

}
