package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OccurrencesAfterBigram {

    public String[] findOcurrences(String text, String first, String second) {
        List<String> list = new ArrayList<>();
        String[] words = text.split(" ");
        for (int i = 0; i < words.length - 2; i++)
            if (words[i].equals(first) && words[i + 1].equals(second))
                list.add(words[i + 2]);
        return (String[]) list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new OccurrencesAfterBigram()
                .findOcurrences("we will we will rock you", "we", "will")));
    }

}
