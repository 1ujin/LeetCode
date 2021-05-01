package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrickWall {
    
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> row : wall) {
            int sum = 0;
            for (int i = 0; i < row.size() - 1; i++) {
                sum += row.get(i);
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int max = 0;
        for (int edge : map.values())
            max = Math.max(max, edge);
        return wall.size() - max;
    }

    public static void main(String[] args) {
        List<List<Integer>> wall = Arrays.asList(
                Arrays.asList(1,2,2,1),
                Arrays.asList(3,1,2),
                Arrays.asList(1,3,2),
                Arrays.asList(2,4),
                Arrays.asList(3,1,2),
                Arrays.asList(1,3,1,1));
        System.out.println(new BrickWall().leastBricks(wall));
    }

}
