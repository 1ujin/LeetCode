package algorithms;

public class ReverseString2 {

    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        for (int i = 0; i < len; i += k * 2) {
            int lo = i, hi = Math.min(i + k, len) - 1;
            while (lo < hi) {
                char c = cs[lo];
                cs[lo++] = cs[hi];
                cs[hi--] = c;
            }
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString2().reverseStr("abcdefg", 2));
    }

}
