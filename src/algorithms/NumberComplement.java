package algorithms;

public class NumberComplement {

    public int findComplement(int num) {
        return num ^ -1 >>> Integer.numberOfLeadingZeros(num);
    }

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(5));
    }

}
