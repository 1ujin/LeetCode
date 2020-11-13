package algorithms;

public class ShuffleString {
    
    public String restoreString(String s, int[] indices) {
        char[] cs1 = s.toCharArray(), cs2 = new char[indices.length];
        for (int i = 0; i < indices.length; i++)
            cs2[indices[i]] =cs1[i];
        return String.valueOf(cs2);
    }

    public static void main(String[] args) {
        int[] indices = { 4, 5, 6, 7, 0, 2, 1, 3 };
        System.out.println(new ShuffleString().restoreString("codeleet", indices));
    }

}
