package algorithms;

public class TruncateSentence {

    public String truncateSentence(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ')
                k--;
            if (k <= 0)
                break;
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new TruncateSentence()
                .truncateSentence("Hello how are you Contestant", 4));
    }

}
