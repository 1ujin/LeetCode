package algorithms;

public class ReverseWordsInAString3 {
    
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != 0)
                sb.append(' ');
            char[] cs = words[i].toCharArray();
            for (int j = cs.length - 1; j >= 0; j--)
                sb.append(cs[j]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAString3().reverseWords("Let's take LeetCode contest"));
    }

}
