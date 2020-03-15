package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation1 {
    
    // method 1
    public String[] permutation1(String S) {
        List<String> strs = new ArrayList<>();
        permutate1(S, new StringBuilder(), strs);
        return strs.toArray(new String[strs.size()]);
    }
    
    private void permutate1(String S, StringBuilder sb, List<String> strs) {
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            StringBuilder tmp = new StringBuilder(sb);
            if (tmp.indexOf(String.valueOf(c)) < 0) tmp.append(c);
            else continue;
            if (tmp.length() == S.length()) strs.add(tmp.toString());
            else permutate1(S, tmp, strs);
        }
    }
    
    // method 2
    public String[] permutation2(String S) {
        List<String> list = new ArrayList<>();
        permutate2(list, S.toCharArray(), 0);
        return list.toArray(new String[list.size()]);
    }

    private void permutate2(List<String> list, char[] S, int start) {
        if (start == S.length) list.add(new String(S));
        else for (int i = start; i < S.length; i++) {
            char tmp = S[start];
            S[start] = S[i];
            S[i] = tmp;
            permutate2(list, S, start + 1);
            S[i] = S[start];
            S[start] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation1().permutation2("qwe")));
    }

}
