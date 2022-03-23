package algorithms;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {

    public boolean winnerOfGame(String colors) {
        int countA = 0, countB = 0;
        char[] cs = (colors + "C").toCharArray();
        char pre = cs[0];
        for (int i = 1, j = 0; i < cs.length; i++) {
            char c = cs[i];
            if (c == pre)
                continue;
            if (i - j > 2) {
                if (pre == 'A')
                    countA += i - j - 2;
                else
                    countB += i - j - 2;
            }
            j = i;
            pre = c;
        }
        return countA > countB;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveColoredPiecesIfBothNeighborsAreTheSameColor().winnerOfGame("ABBBBBBBAAA"));
    }

}
