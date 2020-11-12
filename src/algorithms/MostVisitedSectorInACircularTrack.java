package algorithms;

import java.util.ArrayList;
import java.util.List;

public class MostVisitedSectorInACircularTrack {

    public List<Integer> mostVisited(int n, int[] rounds) {
        List<Integer> list = new ArrayList<>();
        int begin = rounds[0], end = rounds[rounds.length - 1];
        if (begin <= end) {
            for (int i = begin; i <= end; i++)
                list.add(i);
        } else {
            for (int i = 1; i <= end; i++)
                list.add(i);
            for (int i = begin; i <= n; i++)
                list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] rounds = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
        System.out.println(new MostVisitedSectorInACircularTrack().mostVisited(2, rounds ));
    }

}
