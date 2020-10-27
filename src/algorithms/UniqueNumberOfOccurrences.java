package algorithms;

public class UniqueNumberOfOccurrences {
    
    public boolean uniqueOccurrences(int[] arr) {
        int[] count = new int[2001];
        boolean[] countcount = new boolean[1000];
        for (int i : arr)
            count[i + 1000]++;
        for (int i : count) {
            if (i > 0) {
                if (countcount[i - 1])
                    return false;
                else countcount[i - 1] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = { -3, 0, 1, -3, 1, 1, 1, -3, 10, 0 };
        System.out.println(new UniqueNumberOfOccurrences().uniqueOccurrences(arr));
    }

}
