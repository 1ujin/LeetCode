package algorithms;

public class CountAndSay {
    
    public static String countAndSay(int n) {
        if (n <= 0) return "";
        StringBuffer string = new StringBuffer("1");
        string = recursive(string, n);
        return string.toString();
    }
    
    public static StringBuffer recursive(StringBuffer string, int n) {
        if (n <= 1) return string;
        StringBuffer tmp = new StringBuffer();
        int currentCount = 1;
        if (string.length() >= 2) {
            for (int cursor = 0; cursor < string.length() - 1; cursor++) {
                if (string.charAt(cursor) != string.charAt(cursor + 1)) {
                    tmp.append(currentCount);
                    tmp.append(string.charAt(cursor));
                    currentCount = 1;
                } else {
                    currentCount++;
                }
            }
            if (string.charAt(string.length() - 1) == string.charAt(string.length() - 2)) {
                tmp.append(currentCount);
            } else {
                tmp.append(1);
            }
        } else {
            tmp.append(1);
        }
        tmp.append(string.charAt(string.length() - 1));
        return recursive(tmp, --n);
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        String string = countAndSay(6);
        long endTime = System.nanoTime();
        System.out.println(string);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
