package algorithms;

public class LongestUncommonSubsequence1 {

    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }

    public static void main(String[] args) {
        System.out.println(new LongestUncommonSubsequence1().findLUSlength("aba", "cdc"));
    }

}
