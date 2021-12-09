package algorithms;

public class ShortestCompletingWord {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] count = new int[26];
        for (char c : licensePlate.toCharArray()) {
            if (c >= 'a')
                count[c - 'a']++;
            else if (c >= 'A')
                count[c - 'A']++;
        }
        int len = Integer.MAX_VALUE;
        String result = null;
        outer: for (String word : words) {
            int[] wordCount = new int[26];
            for (char c : word.toCharArray())
                wordCount[c - 'a']++;
            for (int i = 0; i < 26; i++)
                if (count[i] > wordCount[i])
                    continue outer;
            if (len > word.length()) {
                len = word.length();
                result = word;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] words = { "claim", "consumer", "student", "camera", "public",
                "never", "wonder", "simple", "thought", "use" };
        System.out.println(new ShortestCompletingWord()
                .shortestCompletingWord("iMSlpe4", words));
    }

}
