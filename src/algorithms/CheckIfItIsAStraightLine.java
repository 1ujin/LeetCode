package algorithms;

public class CheckIfItIsAStraightLine {
    
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3)
            return true;
        int[] begin = coordinates[0];
        if (coordinates[1][1] == begin[1]) {
            for (int i = 2; i < coordinates.length; i++)
                if (coordinates[i][1] != begin[1])
                    return false;
        } else {
            float k = (float) (coordinates[1][0] - begin[0]) / (float) (coordinates[1][1] - begin[1]);
            for (int i = 2; i < coordinates.length; i++)
                if (coordinates[i][1] == begin[1] || k != (float) (coordinates[i][0] - begin[0]) / (float) (coordinates[i][1] - begin[1]))
                    return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] coordinates = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } };
        System.out.println(new CheckIfItIsAStraightLine().checkStraightLine(coordinates));
    }

}
