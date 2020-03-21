package lcci;

public class SparseArraySearch {
    
    public int findString(String[] words, String s) {
        return dichotomy(0, words.length - 1, words, s);
    }
    
    private int dichotomy(int left, int right, String[] words, String s) {
        int index = -1;
        if (left <= right) {
            while (words[left].length() == 0) left++;
            while (words[right].length() == 0) right--;
            int mid = (left + right) / 2;
            if (words[mid].equals(s)) return mid;
            index = dichotomy(left, mid - 1, words, s);
            index = index == -1 ? dichotomy(mid + 1, right, words, s) : index;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new SparseArraySearch().
                findString(new String[] {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""}, "ball"));
    }

}
