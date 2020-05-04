package lcof;

public class Solution64 {
    
    public int sumNums(int n) {
        @SuppressWarnings("unused")
        boolean z = n > 1 && (n += sumNums(n - 1)) > 0; 
        return n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution64().sumNums(9));
    }

}
