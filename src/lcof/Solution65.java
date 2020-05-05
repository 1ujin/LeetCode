package lcof;

public class Solution65 {
    
    public int add(int a, int b) {
        while (b != 0) {
            int t = a;
            a ^= b;
            b = (t & b) << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Solution65().add(6, 4));
    }

}
