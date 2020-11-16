package algorithms;

import java.util.Arrays;

public class MatrixCellsInDistanceOrder {
    
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int[][] cells = new int[R * C][2];
        cells[0][0] = r0;
        cells[0][1] = c0;
        int index = 1, distance = 0;
        while (++distance <= R + C) {
            for (int i = 0; i < distance; i++) {
                if (index < cells.length && r0 - i >= 0 && c0 - (distance - i) >= 0) {
                    cells[index][0] = r0 - i;
                    cells[index][1] = c0 - (distance - i);
                    index++;
                }
                if (index < cells.length && r0 + i < R && c0 + (distance - i) < C) {
                    cells[index][0] = r0 + i;
                    cells[index][1] = c0 + (distance - i);
                    index++;
                }
                if (index < cells.length && r0 + (distance - i) < R && c0 - i >= 0) {
                    cells[index][0] = r0 + (distance - i);
                    cells[index][1] = c0 - i;
                    index++;
                }
                if (index < cells.length && r0 - (distance - i) >= 0 && c0 + i < C) {
                    cells[index][0] = r0 - (distance - i);
                    cells[index][1] = c0 + i;
                    index++;
                }
            }
        }
        return cells;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new MatrixCellsInDistanceOrder()
                .allCellsDistOrder(1, 2, 0, 0)));
    }

}
