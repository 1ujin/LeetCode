package algorithms;

public class RepeatedSubstringPattern {
    
    public boolean repeatedSubstringPattern(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length;
        if (len < 2) return false;
        int count = 1;
        while (++count <= len) {
            if (len % count != 0) continue;
            int sublen = len / count;
            if (sublen < 1) return false;
            for (int i = sublen; i < len; i++) {
                if (cs[i] != cs[i % sublen]) break;
                else if (i == len - 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().repeatedSubstringPattern("bb"));
    }

}
