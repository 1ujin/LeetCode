package algorithms;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {

    public List<Integer> addToArrayForm(int[] A, int K) {
        LinkedList<Integer> list = new LinkedList<>();
        int carry = 0, i = A.length - 1;
        while (K != 0 || carry != 0 || i >= 0) {
            carry += K % 10 + (i >= 0 ? A[i] : 0);
            list.addFirst(carry % 10);
            carry /= 10;
            K /= 10;
            i--;
        }
        return list;
    }

    public static void main(String[] args) {
        int[] A = { 1, 2, 0, 0 };
        System.out.println(new AddToArrayFormOfInteger().addToArrayForm(A, 34));
    }

}
