package algorithms;

public class MaximumNumberOfBalloons {

    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        for (char c : text.toCharArray())
            count[c - 'a']++;
        int num = Integer.MAX_VALUE;
        for (char c : "balloon".toCharArray())
            num = Math.min(num, count[c - 'a'] / (c == 'l' || c == 'o' ? 2 : 1));
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new MaximumNumberOfBalloons()
                .maxNumberOfBalloons("loonbalxballpoon"));
    }

}
