package algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        Queue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (a, b) -> a.getValue() == b.getValue()
                        ? a.getKey().compareTo(b.getKey())
                        : b.getValue() - a.getValue());
        map.entrySet().forEach(queue::offer);
        List<String> list = new ArrayList<>();
        while (k-- > 0)
            list.add(queue.poll().getKey());
        return list;
    }

    public static void main(String[] args) {
        String[] words = { "the", "day", "is", "sunny", "the", "the", "the",
                "sunny", "is", "is" };
        System.out.println(new TopKFrequentWords().topKFrequent(words, 4));
    }

}
