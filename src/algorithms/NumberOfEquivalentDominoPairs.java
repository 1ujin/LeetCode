package algorithms;

public class NumberOfEquivalentDominoPairs {
    
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] map = new int[100];
        int equiv = 0;
        for (int[] dominoe : dominoes) {
            int current = dominoe[0] < dominoe[1] ? dominoe[0] * 10 + dominoe[1]
                    : dominoe[1] * 10 + dominoe[0];
            equiv += map[current]++;
        }
        return equiv;
    }

    public static void main(String[] args) {
        int[][] dominoes = { { 1, 1 }, { 2, 2 }, { 1, 1 }, { 1, 2 }, { 1, 2 },
                { 1, 1 } };
        System.out.println(new NumberOfEquivalentDominoPairs().numEquivDominoPairs(dominoes));
    }

}
