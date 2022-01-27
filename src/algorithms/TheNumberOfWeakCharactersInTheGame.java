package algorithms;

import java.util.Arrays;

public class TheNumberOfWeakCharactersInTheGame {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties,
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int count = 0, max = 0;
        for (int[] propertie : properties) {
            if (propertie[1] < max)
                count++;
            else
                max = propertie[1];
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] properties = { { 1, 1 }, { 2, 1 }, { 2, 2 }, { 1, 2 } };
        System.out.println(new TheNumberOfWeakCharactersInTheGame()
                .numberOfWeakCharacters(properties));
    }

}
