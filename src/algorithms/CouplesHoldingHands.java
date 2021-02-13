package algorithms;

public class CouplesHoldingHands {

    public int minSwapsCouples(int[] row) {
        int count = 0;
        for (int i = 0; i < row.length; i += 2) {
            int diff = (row[i] & 1) == 0 ? 1 : -1;
            if (row[i + 1] != row[i] + diff) {
                for (int j = i + 2; j < row.length; j++) {
                    if (row[j] == row[i] + diff) {
                        swap(row, i + 1, j);
                        count++;
                        break;
                    }
                }
            }
        }
        return count;
    }

    private void swap(int[] row, int i, int j) {
        int k = row[i];
        row[i] = row[j];
        row[j] = k;
    }

    public static void main(String[] args) {
        int[] row = { 0, 2, 1, 3 };
        System.out.println(new CouplesHoldingHands().minSwapsCouples(row));
    }

}
