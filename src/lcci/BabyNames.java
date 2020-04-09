package lcci;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BabyNames {

    // time limit exceeded
    public String[] trulyMostPopularTLE(String[] names, String[] synonyms) {
        Map<String, Integer> namesMap = new HashMap<>();
        Map<String, Integer> resultMap = new HashMap<>();
        Map<String, String> synonymsMap = new HashMap<>();
        for (String name : names) {
            int index = name.indexOf('(');
            namesMap.put(name.substring(0, index), Integer
                    .valueOf(name.substring(index + 1, name.length() - 1)));
        }
        for (String synonym : synonyms) {
            int index = synonym.indexOf(',');
            String name1 = synonym.substring(1, index);
            String name2 = synonym.substring(index + 1, synonym.length() - 1);
            if (name1.compareTo(name2) < 0) {
                String t = name1;
                name1 = name2;
                name2 = t;
            }
            String name3 = synonymsMap.get(name1);
            String name4 = synonymsMap.get(name2);
            if (name3 == null && name4 == null) {
                for (Map.Entry<String, String> e : synonymsMap.entrySet())
                    if (e.getValue().equals(name1))
                        synonymsMap.put(e.getKey(), name2);
                synonymsMap.put(name1, name2);
            } else if (name3 == null) {
                if (name1.compareTo(name4) < 0) {
                    name3 = name1;
                    name1 = name4;
                    name4 = name3;
                }
                for (Map.Entry<String, String> e : synonymsMap.entrySet())
                    if (e.getValue().equals(name1) || e.getValue().equals(name2))
                        synonymsMap.put(e.getKey(), name4);
                synonymsMap.put(name1, name4);
                synonymsMap.put(name2, name4);
            } else if (name4 == null) {
                if (name2.compareTo(name3) < 0) {
                    name4 = name2;
                    name2 = name3;
                    name3 = name4;
                }
                for (Map.Entry<String, String> e : synonymsMap.entrySet())
                    if (e.getValue().equals(name1) || e.getValue().equals(name2))
                        synonymsMap.put(e.getKey(), name3);
                synonymsMap.put(name1, name3);
                synonymsMap.put(name2, name3);
            } else if (name3.compareTo(name4) < 0) {
                for (Map.Entry<String, String> e : synonymsMap.entrySet())
                    if (e.getValue().equals(name1) || e.getValue().equals(name2) || e.getValue().equals(name4))
                        synonymsMap.put(e.getKey(), name3);
                synonymsMap.put(name1, name3);
                synonymsMap.put(name2, name3);
                synonymsMap.put(name4, name3);
            } else {
                for (Map.Entry<String, String> e : synonymsMap.entrySet())
                    if (e.getValue().equals(name1) || e.getValue().equals(name2) || e.getValue().equals(name3))
                        synonymsMap.put(e.getKey(), name4);
                synonymsMap.put(name1, name4);
                synonymsMap.put(name2, name4);
                synonymsMap.put(name3, name4);
            }
        }
        for (Map.Entry<String, Integer> e : namesMap.entrySet()) {
            String key = e.getKey();
            key = synonymsMap.getOrDefault(key, key);
            resultMap.compute(key, (k, v) -> {
                if (v == null)
                    v = 0;
                v += e.getValue();
                return v;
            });
        }
        return resultMap.entrySet().stream().map(e -> {
            StringBuilder sb = new StringBuilder(e.getKey());
            sb.append('(');
            sb.append(e.getValue());
            sb.append(')');
            return sb.toString();
        }).toArray(String[]::new);
    }
    
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> namesMap = new HashMap<>();
        Map<String, String> synonymsMap = new HashMap<>();
        for (String name : names) {
            int index = name.indexOf('(');
            namesMap.put(name.substring(0, index), Integer
                    .valueOf(name.substring(index + 1, name.length() - 1)));
        }
        for (String synonym : synonyms) {
            int index = synonym.indexOf(',');
            String name1 = synonym.substring(1, index);
            String name2 = synonym.substring(index + 1, synonym.length() - 1);
            while (synonymsMap.containsKey(name1))
                name1 = synonymsMap.get(name1);
            while (synonymsMap.containsKey(name2))
                name2 = synonymsMap.get(name2);
            if (name1.equals(name2)) continue;
            if (name1.compareTo(name2) < 0) {
                String t = name1;
                name1 = name2;
                name2 = t;
            }
            synonymsMap.put(name1, name2);
            int sum = namesMap.getOrDefault(name1, 0)
                    + namesMap.getOrDefault(name2, 0);
            namesMap.put(name2, sum);
            namesMap.remove(name1);
        }
        return namesMap.entrySet().stream().map(e -> {
            StringBuilder sb = new StringBuilder(e.getKey());
            sb.append('(');
            sb.append(e.getValue());
            sb.append(')');
            return sb.toString();
        }).toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] names = { "John(15)", "Jon(12)", "Chris(13)", "Kris(4)",
                "Christopher(19)" };
        String[] synonyms = { "(Jon,John)", "(John,Johnny)", "(Chris,Kris)",
                "(Chris,Christopher)" };
        System.out.println(Arrays
                .toString(new BabyNames().trulyMostPopular(names, synonyms)));
    }

}
