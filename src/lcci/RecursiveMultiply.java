package lcci;

public class RecursiveMultiply {
    
    public int multiply(int A, int B) {
        if (A == 0 || B == 0) return 0;
        if (A == 1) return B;
        if (B == 1) return A;
        int tmp = A;
        if (A > B) {
            A = B;
            B = tmp;
        }
        tmp = multiply(A / 2, B) + multiply(A / 2, B);
        return A % 2 == 0 ? tmp : tmp + B;
    }

    public static void main(String[] args) {
        System.out.println(new RecursiveMultiply().multiply(99, 100));
    }

}
