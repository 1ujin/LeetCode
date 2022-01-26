package algorithms;

public class NumberOfValidWordsInASentence {

    public int countValidWords(String sentence) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : sentence.toCharArray()) {
            if (c == ' ') {
                if (sb.length() > 0 && isValid(sb.toString()))
                    count++;
                sb = new StringBuilder();
            } else {
                sb.append(c);
            }
        }
        if (sb.length() > 0 && isValid(sb.toString()))
            count++;
        return count;
    }

    private boolean isValid(String word) {
        char[] cs = word.toCharArray();
        int len = cs.length;
        boolean hasHyphens = false;
        for (int i = 0; i < len; i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                return false;
            } else if (cs[i] == '-') {
                if (hasHyphens == true || i == 0 || i == len - 1
                        || cs[i - 1] < 'A' || cs[i - 1] > 'z'
                        || cs[i - 1] > 'Z' && cs[i - 1] < 'a'
                        || cs[i + 1] < 'A' || cs[i + 1] > 'z'
                        || cs[i + 1] > 'Z' && cs[i + 1] < 'a')
                    return false;
                hasHyphens = true;
            } else if (i != len - 1
                    && (cs[i] == '!' || cs[i] == '.' || cs[i] == ',')) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfValidWordsInASentence().countValidWords(
                "he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }

}
