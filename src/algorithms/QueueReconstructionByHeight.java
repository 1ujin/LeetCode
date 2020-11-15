package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueueReconstructionByHeight {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]);
        List<int[]> list = new ArrayList<>();
        for (int[] p : people) list.add(p[1], p);
        return list.toArray(new int[people.length][2]);
    }

    public static void main(String[] args) {
        int[][] people = { { 7, 0 }, { 4, 4 }, { 7, 1 }, { 5, 0 }, { 6, 1 }, { 5, 2 } };
        System.out.println(Arrays.deepToString(new QueueReconstructionByHeight()
                .reconstructQueue(people)));
    }

}
