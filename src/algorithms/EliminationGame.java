package algorithms;

public class EliminationGame {

    public int lastRemaining(int n) {
        int first = 1, move = 1;
        boolean reverse = false;
        while (n > 1) {
            // 正向或逆向奇数长度
            if (!reverse || n % 2 == 1)
                first += move;
            n >>>= 1;
            move <<= 1;
            reverse = !reverse;
        }
        return first;
    }

    public static void main(String[] args) {
        System.out.println(new EliminationGame().lastRemaining(9));
    }

}
