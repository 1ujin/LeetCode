package algorithms;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for (int type : candyType)
            set.add(type);
        return Math.min(set.size(), candyType.length >> 1);
    }

    public static void main(String[] args) {
        int[] candyType = { 1, 1, 2, 2, 3, 3 };
        System.out.println(new DistributeCandies().distributeCandies(candyType));
    }

}
