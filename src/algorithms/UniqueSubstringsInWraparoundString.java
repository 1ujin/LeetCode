package algorithms;

public class UniqueSubstringsInWraparoundString {

    public int findSubstringInWraproundString(String p) {
        int[] dp = new int[26];
        char[] cs = p.toCharArray();
        for (int i = 0, j = 0; i < cs.length; i++) {
            int current = cs[i] - 'a', last = current == 0 ? 25 : current - 1;
            j = i > 0 && last == cs[i - 1] - 'a' ? j + 1 : 1;
            dp[current] = dp[current] > j ? dp[current] : j;
        }
        int sum = 0;
        for (int i : dp)
            sum += i;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new UniqueSubstringsInWraparoundString()
                .findSubstringInWraproundString("zab"));
    }

}
