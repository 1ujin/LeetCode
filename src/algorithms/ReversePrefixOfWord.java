package algorithms;

public class ReversePrefixOfWord {

    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder();
        int a = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                a = i;
                break;
            }
        }
        int b = a + 1;
        while (a >= 0)
            sb.append(word.charAt(a--));
        while (b < word.length())
            sb.append(word.charAt(b++));
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReversePrefixOfWord()
                .reversePrefix("abcdefd", 'd'));
    }

}
