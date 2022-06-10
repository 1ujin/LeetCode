package algorithms;

public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {
        int dp0 = 0, dp1 = 0;
        for (char c : s.toCharArray()) {
            dp1 = (dp0 < dp1 ? dp0 : dp1) + (c == '0' ? 1 : 0);
            dp0 += c == '1' ? 1 : 0;
        }
        return dp0 < dp1 ? dp0 : dp1;
    }

    public static void main(String[] args) {
        System.out.println(new FlipStringToMonotoneIncreasing()
                .minFlipsMonoIncr("0101100011"));
    }

}
