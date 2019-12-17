package algorithms;

import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	
	public static List<String> letterCombinations(String digits) {
        return null;
    }

	public static void main(String[] args) {
		long startTime = System.nanoTime();
        System.out.println(letterCombinations("23"));
        long endTime = System.nanoTime();
        System.out.print("Duration: " + (endTime - startTime) + "ns");

	}

}
