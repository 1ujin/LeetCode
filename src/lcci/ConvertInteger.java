package lcci;

public class ConvertInteger {
    
    public int convertInteger(int A, int B) {
        return Integer.bitCount(A ^ B);
    }

    public static void main(String[] args) {
        System.out.println(new ConvertInteger().convertInteger(29, 15));
    }

}
