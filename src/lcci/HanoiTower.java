package lcci;

import java.util.ArrayList;
import java.util.List;

public class HanoiTower {
    
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        hanota(A.size(), A, B, C);
    }
    
    public void hanota(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        if (n == 1) C.add(A.remove(A.size() - 1));
        else {
            hanota(n - 1, A, C, B);
            hanota(1, A, B, C);
            hanota(n - 1, B, A, C);
        }
    }

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(), C = new ArrayList<>();
        A.add(2); A.add(1); A.add(0);
        long startTime = System.nanoTime();
        new HanoiTower().hanota(A, new ArrayList<>(), C);
        long endTime = System.nanoTime();
        System.out.println(C);
        System.out.print("Duration: " + (endTime - startTime) + "ns");
    }

}
