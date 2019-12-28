package algorithms;

public class ImplementStrStr {
    
    // 暴力
    public static int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) return 0;
        int i = -1, j = -1;
        for (; i < haystack.length() - needle.length();) {
            int tmp = i;
            while (true) {
                char h = haystack.charAt(i + 1), n = needle.charAt(j + 1);
                if (h == n) {
                    i++;
                    j++;
                    if (j + 1 == needle.length()) {
                        return tmp + 1;
                    }
                } else {
                    i = ++tmp;
                    j = -1;
                    break;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        int index = strStr("aaaaaaaaab", "ab");
        long endTime = System.nanoTime();
        System.out.println(index);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
