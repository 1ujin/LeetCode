package algorithms;

public class SmallestStringWithAGivenNumericValue {
    
    public String getSmallestString(int n, int k) {
        char[] cs = new char[n];
        for (int i = 0; i < n; i++) {
            int j = 1;
            for (; j <= 26 && (n - i - 1) * 26 < k - j; j++);
            k -= j;
            cs[i] = (char) ('a' + j - 1);
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        System.out.println(new SmallestStringWithAGivenNumericValue().getSmallestString(5, 73));
    }

}
