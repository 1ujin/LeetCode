package algorithms;

public class ReverseWordsInAString {
    
    // method 1
    public String reverseWords1(String s) {
        StringBuilder sb = new StringBuilder(), word = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ' && word.length() != 0) {
                word.append(' ');
                sb.insert(0, word);
                word = new StringBuilder();
            } else if (c != ' ')
                word.append(c);
        }
        if (word.length() != 0) {
            word.append(' ');
            sb.insert(0, word);
        }
        if (sb.length() > 0)
            sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
    
    // method 2
    public String reverseWords2(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > -1; i--) {
            sb.append(words[i]);
            if (i != 0)
                sb.append(' ');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new ReverseWordsInAString().reverseWords2("  hello world!  "));
    }

}
