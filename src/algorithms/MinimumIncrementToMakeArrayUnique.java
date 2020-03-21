package algorithms;

import java.util.Arrays;

public class MinimumIncrementToMakeArrayUnique {
    
    // method 1
    public int minIncrementForUnique1(int[] A) {
        int count = 0;
        Arrays.sort(A);
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= A[i - 1]) {
                count += A[i - 1] + 1 - A[i];
                A[i] = A[i - 1] + 1;
            }
        }
        return count;
    }
    
    // method 2
    public int minIncrementForUnique2(int[] A) {
        int[] count = new int[40000 + A.length];
        for (int i : A) count[i]++;
        int result = 0, taken = 0;
        for (int i = 0; i < 40000 + A.length; i++) {
            if (count[i] > 1) {
                taken += count[i] - 1;
                result -= i * (count[i] - 1);
            } else if (taken > 0 && count[i] == 0) {
                taken--;
                result += i;
            }
        }
        return result;
    }
    
    // method 3
    public int minIncrementForUnique3(int[] A) {
        Arrays.sort(A);
        int count = 0, dupl = 0, len = A.length;
        for (int i = 1; i < len; i++) {
            if (A[i] == A[i - 1]) {
                dupl++;
                count -= A[i];
            } else {
                // 如果A[i - 1] 和 A[i] 之间不足 dupl 个数则选取中间全部的数
                int distance = Math.min(dupl, A[i] - A[i - 1] - 1);
                // A[i - 1] 和 A[i] 之间的前 distance 个数的和
                count += (A[i - 1] + 1 + A[i - 1] + distance) * distance / 2;
                dupl -= distance;
            }
        }
        if (len > 0) count += (A[len - 1] + 1 + A[len - 1] + dupl) * dupl / 2;
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new MinimumIncrementToMakeArrayUnique().
                minIncrementForUnique3(new int[] {3, 2, 1, 2, 1, 7}));
    }

}
