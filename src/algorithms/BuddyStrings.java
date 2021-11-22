package algorithms;

public class BuddyStrings {

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        char[] cs1 = s.toCharArray(), cs2 = goal.toCharArray();
        int len = cs1.length;
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (int i = 0; i < len; i++) {
                count[cs1[i] - 'a']++;
                if (count[cs1[i] - 'a'] > 1)
                    return true;
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int i = 0; i < len; i++) {
                if (cs1[i] != cs2[i]) {
                    if (first == -1)
                        first = i;
                    else if (second == -1)
                        second = i;
                    else
                        return false;
                }
            }
            return second != -1 && cs1[first] == cs2[second]
                    && cs1[second] == cs2[first];
        }
    }

    public static void main(String[] args) {
        System.out.println(new BuddyStrings().buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }

}
