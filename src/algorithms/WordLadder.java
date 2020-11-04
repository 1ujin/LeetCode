package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadder {
    
    int num = 0;
    List<List<Integer>> edges = new ArrayList<>();
    Map<String, Integer> map = new HashMap<>();
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.stream().forEach(this::addEdge);
        addEdge(beginWord);
        if (!map.containsKey(endWord)) return 0;
        int[] distances = new int[num];
        Arrays.fill(distances, -1 >>> 1);
        int beginId = map.get(beginWord), endId = map.get(endWord);
        distances[beginId] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);
        while (!queue.isEmpty()) {
            int id = queue.poll();
            if (id == endId)
                return (distances[endId] >> 1) + 1;
            for (int i : edges.get(id)) {
                if (distances[i] == -1 >>> 1) {
                    distances[i] = distances[id] + 1;
                    queue.offer(i);
                }
            }
        }
        return 0;
    }

    private void addEdge(String word) {
        addWord(word);
        int id1 = map.get(word);
        char[] cs = word.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            char t = cs[i];
            cs[i] = '_';
            String replaceWord = String.valueOf(cs);
            addWord(replaceWord);
            int id2 = map.get(replaceWord);
            edges.get(id1).add(id2);
            edges.get(id2).add(id1);
            cs[i] = t;
        }
    }

    private void addWord(String word) {
        if (map.containsKey(word)) return;
        map.put(word, num++);
        edges.add(new ArrayList<>());
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        System.out.println(new WordLadder().ladderLength("hit", "cog", wordList));
    }

}
