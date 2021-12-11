package algorithms;

public class ToLowerCase {

    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
            sb.append(c >= 'A' && c <= 'Z' ? (char) (c - 'A' + 'a') : c);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ToLowerCase().toLowerCase("al&phaBET"));
    }

}
