package algorithms;

public class NumberOfRectanglesThatCanFormTheLargestSquare {

    public int countGoodRectangles(int[][] rectangles) {
        int maxSize = 0, count = 0;
        for (int[] rectangle : rectangles) {
            int size = Math.min(rectangle[0], rectangle[1]);
            if (maxSize == size)
                count++;
            else if (maxSize < size) {
                maxSize = size;
                count = 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] rectangles = { { 5, 8 }, { 3, 9 }, { 5, 12 }, { 16, 5 } };
        System.out.println(new NumberOfRectanglesThatCanFormTheLargestSquare()
                .countGoodRectangles(rectangles));
    }

}
