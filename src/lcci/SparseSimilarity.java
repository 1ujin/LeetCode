package lcci;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//import java.util.stream.Collectors;

public class SparseSimilarity {
    
    // time limit exceeded
    public List<String> computeSimilaritiesTLE(int[][] docs) {
        Map<String, Float> map = new HashMap<>();
        for (int i = 0; i < docs.length; i++) {
            for (int j = i + 1; j < docs.length; j++) {
                int[] nums1 = docs[i], nums2 = docs[j];
                int dupl = 0;
                for (int num1 : nums1)
                    for (int num2 : nums2)
                        if (num1 == num2)
                            dupl++;
                float similarity = (float) dupl
                        / (float) (nums1.length + nums2.length - dupl);
                if (similarity <= 0) continue;
                String key = String.format("%d,%d", i, j);
                map.put(key, similarity);
            }
        }
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Float> e : map.entrySet())
            result.add(String.format("%s: %.4f", e.getKey(), e.getValue()));
        return result;
//        return map.entrySet().stream()
//                .map(e -> String.format("%s: %.4f", e.getKey(), e.getValue()))
//                .collect(Collectors.toList());
    }
    
    public List<String> computeSimilarities(int[][] docs) {
        List<String> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[][] dupl = new int[docs.length][docs.length];
        for (int i = 0; i < docs.length; i++) {
            int index = i;
            for (int j = 0; j < docs[i].length; j++) {
                map.compute(docs[i][j], (k, v) -> {
                    if (v == null)
                        v = new ArrayList<>();
                    else for (int num : v)
                        dupl[index][num]++;
                    v.add(index);
                    return v;
                });
            }
            for (int j = 0; j < i; j++) {
                if (dupl[i][j] == 0) continue;
                float similarity = (float) dupl[i][j] / (float) (docs[i].length
                        + docs[j].length - dupl[i][j]);
                result.add(String.format("%d,%d: %.4f", j, i, similarity));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] docs = { { 14, 15, 100, 9, 3 }, { 32, 1, 9, 3, 5 },
                { 15, 29, 2, 6, 8, 7 }, { 7, 10 } };
        System.out.println(new SparseSimilarity().computeSimilarities(docs));
    }

}
