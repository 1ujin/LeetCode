package algorithms;

import java.util.Map;
import java.util.TreeMap;

public class MyCalendar3 {

    private Map<Integer, Integer> map;

    public MyCalendar3() {
        map = new TreeMap<>();
    }

    public int book(int start, int end) {
        int k = 0, max = 0;
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max += entry.getValue();
            k = Math.max(k, max);
        }
        return k;
    }

    public static void main(String[] args) {
        MyCalendar3 myCalendar3 = new MyCalendar3();
        System.out.println(myCalendar3.book(10, 20));   // 返回 1 ，第一个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        System.out.println(myCalendar3.book(50, 60));   // 返回 1 ，第二个日程安排可以预订并且不存在相交，所以最大 k 次预订是 1 次预订。
        System.out.println(myCalendar3.book(10, 40));   // 返回 2 ，第三个日程安排 [10, 40) 与第一个日程安排相交，所以最大 k 次预订是 2 次预订。
        System.out.println(myCalendar3.book(5, 15));    // 返回 3 ，剩下的日程安排的最大 k 次预订是 3 次预订。
        System.out.println(myCalendar3.book(5, 10));    // 返回 3
        System.out.println(myCalendar3.book(25, 55));   // 返回 3
    }

}
