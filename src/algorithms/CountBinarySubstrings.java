package algorithms;

public class CountBinarySubstrings {
    
    public int countBinarySubstrings(String s) {
        char[] cs = s.toCharArray();
        int len = cs.length, i = 0, result = 0, tmp = 0;
        while (i < len) {
            char c = cs[i];
            int count = 0;
            while (i < len && cs[i] == c) {
                i++;
                count++;
            }
            result += Math.min(count, tmp);
            tmp = count;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new CountBinarySubstrings().countBinarySubstrings("00110011"));
    }

}
