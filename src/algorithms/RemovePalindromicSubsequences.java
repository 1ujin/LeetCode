package algorithms;

public class RemovePalindromicSubsequences {

    public int removePalindromeSub(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length >> 1; i++)
            if (cs[i] != cs[cs.length - 1 - i])
                return 2;
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new RemovePalindromicSubsequences().removePalindromeSub("abbaaabbbb"));
    }

}
