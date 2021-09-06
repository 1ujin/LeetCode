package algorithms;

public class SplitAStringInBalancedStrings {

    public int balancedStringSplit(String s) {
        int diff = 0, count = 0;
        for (char c : s.toCharArray()) {
            diff += c == 'L' ? 1 : -1;
            count += diff == 0 ? 1 : 0;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new SplitAStringInBalancedStrings().balancedStringSplit("RLRRLLRLRL"));
    }

}
