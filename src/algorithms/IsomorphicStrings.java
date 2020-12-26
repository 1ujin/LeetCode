package algorithms;

public class IsomorphicStrings {
    
    public boolean isIsomorphic(String s, String t) {
        char[] cs1 = s.toCharArray(), cs2 = t.toCharArray();
        int len = cs1.length;
        if (len < 2) return true;
        int[] pre1 = new int[256], pre2 = new int[256];
        for (int i = 0; i < len; i++) {
            if (pre1[cs1[i]] != pre2[cs2[i]])
                return false;
            pre1[cs1[i]] = i + 1;
            pre2[cs2[i]] = i + 1;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicStrings().isIsomorphic("paper", "title"));
    }

}
