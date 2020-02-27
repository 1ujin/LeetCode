package lcci;

public class FlippedString {
    
    // method 1
    public boolean isFlipedString1(String s1, String s2) {
        return s1.length() == s2.length() && (s2 + s2).contains(s1);
    }
    
    // method 2
    public boolean isFlipedString2(String s1, String s2) {
        if (s1.equals(s2)) return true;
        int cursor = 0, offset = 1, len1 = s1.length(), len2 = s2.length();
        if (len1 != len2) return false;
        while (offset < len2 && (cursor + offset < len2 || offset > cursor)) {
            if (offset <= cursor && cursor + offset < len2 && s1.charAt(cursor) == s2.charAt(cursor + offset)) {
                cursor++;
            } else if (cursor + offset >= len2 && offset > cursor && s1.charAt(len1 - 1 - cursor) == s2.charAt(offset - 1 - cursor)) {
                cursor++;
            } else if (cursor + offset < len2 && offset > cursor && s1.charAt(cursor) == s2.charAt(cursor + offset) && s1.charAt(len1 - 1 - cursor) == s2.charAt(offset - 1 - cursor)) {
                cursor++;
            } else {
                cursor = 0;
                offset++;
            }
        }
        return offset < len2;
    }

    public static void main(String[] args) {
        FlippedString solution = new FlippedString();
        long startTime = System.nanoTime();
        boolean result = solution.isFlipedString2("waterbottle", "erbottlewat");
        long endTime = System.nanoTime();
        System.out.println(result);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
