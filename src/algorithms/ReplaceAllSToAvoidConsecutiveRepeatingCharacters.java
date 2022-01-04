package algorithms;

public class ReplaceAllSToAvoidConsecutiveRepeatingCharacters {

    public String modifyString(String s) {
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == '?') {
                for (char c = 'a'; c <= 'c'; c++) {
                    if ((i > 0 && cs[i - 1] == c)
                            || (i < cs.length - 1 && cs[i + 1] == c))
                        continue;
                    cs[i] = c;
                    break;
                }
            }
        }
        return new String(cs);
    }

    public static void main(String[] args) {
        System.out.println(new ReplaceAllSToAvoidConsecutiveRepeatingCharacters().modifyString("??yw?ipkj?"));
    }

}
