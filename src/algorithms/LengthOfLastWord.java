package algorithms;

public class LengthOfLastWord {
    
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastSpaceIndex = s.lastIndexOf(" ");
        return lastSpaceIndex == -1 ? s.length()
                : s.length() - 1 - lastSpaceIndex;
    }

    public static void main(String[] args) {
        System.out.println(new LengthOfLastWord().lengthOfLastWord("a "));
    }

}
