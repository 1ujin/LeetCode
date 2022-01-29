package algorithms;

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {

    private Map<Integer, Map<Integer, Integer>> map;

    public DetectSquares() {
        map = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        map.putIfAbsent(y, new HashMap<>());
        Map<Integer, Integer> xMap = map.get(y);
        xMap.put(x, xMap.getOrDefault(x, 0) + 1);
    }

    public int count(int[] point) {
        int count = 0, x1 = point[0], y1 = point[1];
        if (!map.containsKey(y1))
            return 0;
        Map<Integer, Integer> y1Map = map.get(y1);
        for (Map.Entry<Integer, Integer> entry : y1Map.entrySet()) {
            int x2 = entry.getKey(), count1 = entry.getValue(), edge = x2 - x1;
            if (edge == 0)
                continue;
            int y2 = y1 + edge;
            if (map.containsKey(y2)) {
                Map<Integer, Integer> y2Map = map.get(y2);
                int count2 = y2Map.getOrDefault(x1, 0);
                int count3 = y2Map.getOrDefault(x2, 0);
                count += count1 * count2 * count3;
            }
            y2 = y1 - edge;
            if (map.containsKey(y2)) {
                Map<Integer, Integer> y2Map = map.get(y2);
                int count2 = y2Map.getOrDefault(x1, 0);
                int count3 = y2Map.getOrDefault(x2, 0);
                count += count1 * count2 * count3;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        DetectSquares detectSquares = new DetectSquares();
        detectSquares.add(new int[] { 3, 10 });
        detectSquares.add(new int[] { 11, 2 });
        detectSquares.add(new int[] { 3, 2 });
        System.out.println(detectSquares.count(new int[] { 11, 10 }));  // 返回 1 。你可以选择：
                                                                        //   - 第一个，第二个，和第三个点
        System.out.println(detectSquares.count(new int[] { 14, 8 }));   // 返回 0 。查询点无法与数据结构中的这些点构成正方形。
        detectSquares.add(new int[] { 11, 2 });                         // 允许添加重复的点。
        System.out.println(detectSquares.count(new int[] { 11, 10 }));  // 返回 2 。你可以选择：
                                                                        //   - 第一个，第二个，和第三个点
                                                                        //   - 第一个，第三个，和第四个点

    }

}
