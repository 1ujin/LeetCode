package lcci;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    
    // method 1 backtracking
    public String[] permutation1(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        boolean[] isUsed = new boolean[S.length()];
        List<String> strs = new ArrayList<>();
        permutate1(chars, isUsed, strs, new StringBuilder());
        return strs.toArray(new String[strs.size()]);
    }
    
    private void permutate1(char[] chars, boolean[] isUsed, List<String> strs, StringBuilder sb) {
        if (sb.length() == chars.length) strs.add(sb.toString());
        else for (int i = 0; i < chars.length; i++) {
            // 对于 [... 'x', 'x', 'x' ...] 从后往前追加，追加 chars[i] 时，在 chars 中前面所有相同的 'x' 都不能被使用过
            if (!isUsed[i] && (i == 0 || chars[i] != chars[i - 1] || !isUsed[i - 1])) {
                sb.append(chars[i]);
                isUsed[i] = true;
                permutate1(chars, isUsed, strs, sb);
                sb.deleteCharAt(sb.length() - 1);
                isUsed[i] = false;
            }
        }
    }
    
    // method 2 backtracking fastest
    public String[] permutation2(String S) {
        List<String> list = new ArrayList<>();
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        permutate2(list, chars, 0);
        return list.toArray(new String[list.size()]);
    }

    private void permutate2(List<String> list, char[] chars, int start) {
        if (start == chars.length) list.add(new String(chars));
        else for (int i = start; i < chars.length; i++) {
            if (start != i && (chars[start] == chars[i] || chars[i] == chars[i - 1])) continue;
            char tmp = chars[start];
            chars[start] = chars[i];
            chars[i] = tmp;
            permutate2(list, chars, start + 1);
            chars[i] = chars[start];
            chars[start] = tmp;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutation2().permutation2("eqq")));
    }

}
