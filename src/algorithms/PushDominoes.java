package algorithms;

public class PushDominoes {

    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int len = cs.length, i = 0;
        char left = 'L';
        while (i < len) {
            int j = i;
            while (j < len && cs[j] == '.')
                j++;
            char right = j < len ? cs[j] : 'R';
            if (left == right) {
                while (i < j)
                    cs[i++] = right;
            } else if (left == 'R' && right == 'L') {
                int k = j - 1;
                while (i < k) {
                    cs[i++] = 'R';
                    cs[k--] = 'L';
                }
            }
            left = right;
            i = j + 1;
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(new PushDominoes().pushDominoes(".L.R...LR..L.."));
    }

}
