package lcci;

public class InsertIntoBits {
    
    public int insertBits(int N, int M, int i, int j) {
        for (int distance = i; distance < j + 1; distance++)
            N = N & Integer.rotateLeft(~1, distance);
        return N | (M << i);
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(new InsertIntoBits().insertBits(2032243561, 10, 24, 29)));
    }

}
