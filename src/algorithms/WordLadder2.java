package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class WordLadder2 {
    
    // method 1 breadth-first search
    public List<List<String>> findLadders1(String beginWord, String endWord,
            List<String> wordList) {
        Queue<List<String>> stepLists = new LinkedList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String word : wordList) {
            char[] cs = word.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char t = cs[i];
                cs[i] = '_';
                map.compute(String.valueOf(cs), (k, v) -> {
                    if (v == null)
                        v = new ArrayList<>();
                    v.add(word);
                    return v;
                });
                cs[i] = t;
            }
        }
        stepLists.offer(new ArrayList<>());
        stepLists.peek().add(beginWord);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        int index = 1;
        Set<String> newVisited = new HashSet<>();
        while (!stepLists.isEmpty()) {
            List<String> stepList = stepLists.peek();
            if (index < stepList.size()) {
                index++;
                visited.addAll(newVisited);
                newVisited.clear();
            }
            if (stepList.get(index - 1).equals(endWord))
                break;
            else stepLists.poll();
            char[] cs = stepList.get(stepList.size() - 1).toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char t = cs[i];
                cs[i] = '_';
                List<String> v = map.get(String.valueOf(cs));
                if (v != null) {
                    List<String> newList = new ArrayList<>(stepList);
                    if (v.contains(endWord)) {
                        newList.add(endWord);
                        newVisited.add(endWord);
                        stepLists.offer(newList);
                        index = stepList.size();
                    } else for (String s : v) {
                        if (!stepList.contains(s) && !visited.contains(s)) {
                            newList = new ArrayList<>(stepList);
                            newList.add(s);
                            newVisited.add(s);
                            stepLists.offer(newList);
                        }
                    }
                }
                cs[i] = t;
            }
        }
        stepLists.removeIf(list -> !list.get(list.size() - 1).equals(endWord));
        return new ArrayList<>(stepLists);
    }
    
    // method 2 breadth-first search + depth-first search fastest
    public List<List<String>> findLadders2(String beginWord, String endWord,
            List<String> wordList) {
        // 结果集
        List<List<String>> res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        // 字典中不包含目标单词
        if (!words.contains(endWord))
            return res;
        // 存放关系：每个单词可达的下层单词
        Map<String, List<String>> mapTree = new HashMap<>();
        Set<String> begin = new HashSet<>(), end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        if (buildTree(words, begin, end, mapTree, true))
            dfs(res, mapTree, beginWord, endWord, new LinkedList<>());
        return res;
    }

    // 双向BFS，构建每个单词的层级对应关系
    private boolean buildTree(Set<String> words, Set<String> begin,
            Set<String> end, Map<String, List<String>> mapTree, boolean isFront) {
        if (begin.size() == 0)
            return false;
        // 始终以少的进行探索
        if (begin.size() > end.size())
            return buildTree(words, end, begin, mapTree, !isFront);
        // 在已访问的单词集合中去除
        words.removeAll(begin);
        // 标记本层是否已到达目标单词
        boolean isMeet = false;
        // 记录本层所访问的单词
        Set<String> nextLevel = new HashSet<>();
        for (String word : begin) {
            char[] chars = word.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char temp = chars[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    chars[i] = ch;
                    String str = String.valueOf(chars);
                    if (words.contains(str)) {
                        nextLevel.add(str);
                        // 根据访问顺序，添加层级对应关系：始终保持从上层到下层的存储存储关系
                        // true: 从上往下探索：word -> str
                        // false: 从下往上探索：str -> word（查找到的 str 是 word 上层的单词）
                        String key = isFront ? word : str;
                        String nextWord = isFront ? str : word;
                        // 判断是否遇见目标单词
                        if (end.contains(str))
                            isMeet = true;
                        if (!mapTree.containsKey(key))
                            mapTree.put(key, new ArrayList<>());
                        mapTree.get(key).add(nextWord);
                    }
                }
                chars[i] = temp;
            }
        }
        if (isMeet) return true;
        return buildTree(words, nextLevel, end, mapTree, isFront);
    }
    
    private void dfs(List<List<String>> res, Map<String, List<String>> mapTree,
            String beginWord, String endWord, LinkedList<String> list) {
        list.add(beginWord);
        if (beginWord.equals(endWord)) {
            res.add(new ArrayList<>(list));
            list.removeLast();
            return;
        }
        if (mapTree.containsKey(beginWord))
            for (String word : mapTree.get(beginWord))
                dfs(res, mapTree, word, endWord, list);
        list.removeLast();
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.stream(
                new String[] { "hot", "dot", "dog", "lot", "log", "cog" })
                .map(s -> s).collect(Collectors.toList());
        System.out.println(new WordLadder2().findLadders2("hit", "cog", wordList));
    }

}
