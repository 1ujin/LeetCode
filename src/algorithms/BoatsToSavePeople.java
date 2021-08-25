package algorithms;

import java.util.Arrays;

public class BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int num = 0, lo = 0, hi = people.length - 1;
        while (lo <= hi) {
            if (people[lo] + people[hi] <= limit)
                lo++;
            hi--;
            num++;
        }
        return num;
    }

    public static void main(String[] args) {
        int[] people = { 3, 2, 2, 1 };
        System.out.println(new BoatsToSavePeople().numRescueBoats(people, 3));
    }

}
