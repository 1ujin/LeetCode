package algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class StockPrice {
    private int current;
    private Map<Integer, Integer> map;
    private TreeMap<Integer, Integer> treeMap;

    public StockPrice() {
        map = new HashMap<>();
        treeMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        current = Math.max(current, timestamp);
        Integer prePrice = map.put(timestamp, price);
        if (prePrice != null) {
            int count = treeMap.get(prePrice);
            if (count == 1)
                treeMap.remove(prePrice);
            else
                treeMap.put(prePrice, count - 1);
        }
        treeMap.put(price, treeMap.getOrDefault(price, 0) + 1);
    }

    public int current() {
        return map.get(current);
    }

    public int maximum() {
        return treeMap.lastKey();
    }

    public int minimum() {
        return treeMap.firstKey();
    }
}

public class StockPriceFluctuation {

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10);                   // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);                    // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        System.out.println(stockPrice.current());   // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        System.out.println(stockPrice.maximum());   // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        stockPrice.update(1, 3);                    // 之前时间戳为 1 的价格错误，价格更新为 3 。
                                                    // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        System.out.println(stockPrice.maximum());   // 返回 5 ，更正后最高价格为 5 。
        stockPrice.update(4, 2);                    // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        System.out.println(stockPrice.minimum());   // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
    }

}
