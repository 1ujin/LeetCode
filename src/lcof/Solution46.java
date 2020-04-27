package lcof;

public class Solution46 {
    
    int count = 1, len;
    
    public int translateNum(int num) {
        char[] cs = String.valueOf(num).toCharArray();
        len = cs.length;
        recur(cs, 1);
        return count;
    }
    
    private void recur(char[] cs, int i) {
        if (i >= len) return;
        if (cs[i - 1] != '0' && (cs[i - 1] - '0') * 10 + cs[i] - '0' < 26) {
            count++;
            recur(cs, i + 2);
        }
        recur(cs, i + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution46().translateNum(506));
    }

}
