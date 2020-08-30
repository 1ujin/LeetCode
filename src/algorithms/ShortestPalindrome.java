package algorithms;

public class ShortestPalindrome {
    
    // method 1
    public String shortestPalindrome1(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        if (len < 2) return s;
        int end = len - 1;
        outer: for (; end >= 0; end--) {
            int mid  = end >> 1;
            for (int i = 0; i <= mid; i++) {
                if (cs[i] != cs[end - i])
                    break;
                if (i == mid)
                    break outer;
            }
        }
        int preLen = len - 1 - end;
        char[] newcs = new char[preLen + len];
        for (int i = 0; i < preLen; i++)
            newcs[i] = cs[len - 1 - i];
        for (int i = 0; i < len; i++)
            newcs[i + preLen] = cs[i];
        return new String(newcs);
    }
    
    // method 2
    public String shortestPalindrome2(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        if (len < 2) return s;
        int i = 0, j = len - 1;
        while(j >= 0) {
            if(cs[i] == cs[j]) i++;
            j--;
        }
        if(i == len) return s;
        String suffix = s.substring(i);
        String prefix = new StringBuilder(suffix).reverse().toString();
        return prefix + shortestPalindrome2(s.substring(0, i)) + suffix;
    }

    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindrome2("aacecaaa")); // aaacecaaa
    }

} 
