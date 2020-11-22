package algorithms;

public class CheckIfTwoStringArraysAreEquivalent {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (String w : word1)
            sb1.append(w);
        for (String w : word2)
            sb2.append(w);
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        String[] word1 = { "ab", "c" }, word2 = { "a", "bc" };
        System.out.println(new CheckIfTwoStringArraysAreEquivalent().arrayStringsAreEqual(word1, word2));
    }

}
