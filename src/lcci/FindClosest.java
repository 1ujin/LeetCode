package lcci;

public class FindClosest {

    public int findClosest(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) index1 = i;
            if (words[i].equals(word2)) index2 = i;
            if (index1 == -1 || index2 == -1) continue;
            int distance = Math.abs(index1 - index2);
            if (distance == 1) return 1;
            min = min < distance ? min : distance;
        }
        return min;
    }

    public static void main(String[] args) {
        String[] words = { "I", "am", "a", "student", "from", "a", "university",
                "in", "a", "city" };
        System.out
                .println(new FindClosest().findClosest(words, "a", "student"));
    }

}
