package algorithms;

public class MonotoneIncreasingDigits {
    
    public int monotoneIncreasingDigits(int N) {
        char[] cs = Integer.toString(N).toCharArray();
        int i = 1;
        while (i < cs.length && cs[i - 1] <= cs[i])
            i++;
        if (i == cs.length) return N;
        while (i > 0 && cs[i - 1] > cs[i])
            cs[--i] -= 1;
        while (++i < cs.length)
            cs[i] = '9';
        return Integer.parseInt(String.valueOf(cs));
    }

    public static void main(String[] args) {
        System.out.println(new MonotoneIncreasingDigits().monotoneIncreasingDigits(1243));
    }

}
