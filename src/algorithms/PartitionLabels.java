package algorithms;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    
    public List<Integer> partitionLabels(String S) {
        char[] cs = S.toCharArray();
        int[] lasts = new int[26];
        for (int i = 0; i < cs.length; i++)
            lasts[cs[i] - 'a'] = i;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            int last = lasts[cs[i] - 'a'], len = last - i + 1;
            for (int j = i + 1; j <= last; j++) {
                if (cs[j] != cs[i] && lasts[cs[j] - 'a'] > last) {
                    last = lasts[cs[j] - 'a'];
                    len = last - i + 1;
                }
            }
            list.add(len);
            i = last;
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new PartitionLabels().partitionLabels("ababcbacadefegdehijhklij"));
    }

}
