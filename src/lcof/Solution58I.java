package lcof;

public class Solution58I {
    
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > -1; i--) {
            if (words[i].equals(""))
                continue;
            sb.append(words[i]);
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution58I().reverseWords("the sky is blue"));
    }

}
