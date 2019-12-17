package algorithms;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    
    private static String[] values = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    private static List<String> list = new ArrayList<String>();
    
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) return list;
        int digit = (int) digits.charAt(0) - 48;
        String letter = values[digit - 2], pop = "";
        int i = 0, len = list.size();
        do {
            if (list.size() > 0) pop = list.remove(0);
            for (int j = 0; j < letter.length(); j++) {
                list.add(pop + letter.charAt(j));
            }
            i++;
        } while (i < len);
        return letterCombinations(digits.substring(1));
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        letterCombinations("234");
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

    }

}
