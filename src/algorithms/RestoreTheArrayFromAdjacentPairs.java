package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestoreTheArrayFromAdjacentPairs {

    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0], new ArrayList<>());
            map.putIfAbsent(adjacentPair[1], new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        int len = adjacentPairs.length + 1;
        int[] ret = new int[len];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                ret[0] = entry.getKey();
                break;
            }
        }
        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < len; i++) {
            List<Integer> adj = map.get(ret[i - 1]);
            ret[i] = ret[i - 2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }

    public static void main(String[] args) {
        int[][] adjacentPairs = { { 2, 1 }, { 3, 4 }, { 3, 2 } };
        System.out.println(Arrays.toString(new RestoreTheArrayFromAdjacentPairs().restoreArray(adjacentPairs)));
    }

}
