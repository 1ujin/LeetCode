package algorithms;

public class ImplementStrStr {
    
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int i = -1;
        // KMP
        return i;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int index = strStr("hello", "ll");
        long endTime = System.nanoTime();
        System.out.println(index);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
