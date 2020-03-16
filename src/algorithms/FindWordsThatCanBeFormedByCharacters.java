package algorithms;

import java.util.Arrays;

public class FindWordsThatCanBeFormedByCharacters {
    
    // method 1
    public int countCharacters1(String[] words, String chars) {
        char[] charArr = chars.toCharArray();
        Arrays.sort(charArr);
        int count = 0;
        char[] strArr;
        for (String word : words) {
            strArr = word.toCharArray();
            Arrays.sort(strArr);
            int i = 0, j = 0;
            while (i < charArr.length) {
                if (charArr[i] == strArr[j]) {
                    i++;
                    j++;
                } else i++;
                if (j == strArr.length) {
                    count += j;
                    break;
                }
            }
        }
        return count;
    }
    
    // method 2
    public int countCharacters2(String[] words, String chars) {
        int count = 0;
        int[] alphabet = new int[26];
        for (char c : chars.toCharArray())
            alphabet[c - 'a']++;
        LOOP: for (String word : words) {
            int[] tmp = alphabet.clone();
            for (char c : word.toCharArray())
                tmp[c - 'a']--;
            for (int i : tmp)
                if (i < 0) continue LOOP;
            count += word.length();
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new FindWordsThatCanBeFormedByCharacters()
                .countCharacters2(new String[] {"hello", "world", "leetcode"}, "welldonehoneyr"));
    }

}
