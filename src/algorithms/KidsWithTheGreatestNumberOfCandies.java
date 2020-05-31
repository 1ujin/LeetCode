package algorithms;

import java.util.ArrayList;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandies {
    
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int i : candies)
            max = max > i ? max : i;
        List<Boolean> list = new ArrayList<>();
        for (int i : candies)
            list.add(i + extraCandies >= max);
        return list;
//        final int fm = max;
//        return Arrays.stream(candies).mapToObj(n -> n + extraCandies >= fm)
//                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        int[] candies = { 2, 3, 5, 1, 3 };
        System.out.println(new KidsWithTheGreatestNumberOfCandies().kidsWithCandies(candies, 3));
    }

}
