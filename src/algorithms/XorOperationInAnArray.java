package algorithms;

public class XorOperationInAnArray {
    
    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++)
            result ^= start += 2;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new XorOperationInAnArray().xorOperation(5, 0));
    }

}
