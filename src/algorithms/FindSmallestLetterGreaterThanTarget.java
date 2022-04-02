package algorithms;

public class FindSmallestLetterGreaterThanTarget {

    public char nextGreatestLetter(char[] letters, char target) {
        int len = letters.length;
        if (target >= letters[len - 1])
            return letters[0];
        int lo = 0, hi = len - 1;
        while (lo < hi) {
            int mid = lo + hi >> 1;
            char pivot = letters[mid];
            if (target >= pivot)
                lo = mid + 1;
            else
                hi = mid;
        }
        return letters[lo];
    }

    public static void main(String[] args) {
        char[] letters = { 'c', 'f', 'j' };
        System.out.println(new FindSmallestLetterGreaterThanTarget()
                .nextGreatestLetter(letters, 'd'));
    }

}
