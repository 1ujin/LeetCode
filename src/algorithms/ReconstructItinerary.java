package algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class ReconstructItinerary {
    
    List<String> itinerary = new LinkedList<>();
    Map<String, Queue<String>> map = new HashMap<>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0), to = ticket.get(1);
            if (!map.containsKey(from))
                map.put(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }
        dfs("JFK");
        return itinerary;
    }

    private void dfs(String from) {
        if (map.containsKey(from)) {
            Queue<String> queue = map.get(from);
            while (!queue.isEmpty())
                dfs(queue.poll());
        }
        itinerary.add(0, from);
    }

    public static void main(String[] args) {
        List<List<String>> tickets = Arrays.asList(
                Arrays.asList("JFK", "SFO"),
                Arrays.asList("JFK", "ATL"),
                Arrays.asList("SFO", "ATL"),
                Arrays.asList("ATL", "JFK"),
                Arrays.asList("ATL", "SFO"));
        System.out.println(new ReconstructItinerary().findItinerary(tickets));
    }

}
