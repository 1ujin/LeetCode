package algorithms;

public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            while (i < j && (cs[i] < 'A' || cs[i] > 'z'
                    || cs[i] > 'Z' && cs[i] < 'a'))
                i++;
            while (i < j && (cs[j] < 'A' || cs[j] > 'z'
                    || cs[j] > 'Z' && cs[j] < 'a'))
                j--;
            char c = cs[i];
            cs[i++] = cs[j];
            cs[j--] = c;
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseOnlyLetters()
                .reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

}
