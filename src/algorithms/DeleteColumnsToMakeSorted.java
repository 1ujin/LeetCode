package algorithms;

public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {
        int row = strs.length, col = strs[0].length(), count = 0;
        char[][] cs = new char[row][col];
        for (int i = 0; i < row; i++)
            cs[i] = strs[i].toCharArray();
        for (int i = 0; i < col; i++) {
            for (int j = 1; j < row; j++) {
                if (cs[j][i] < cs[j - 1][i]) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] strs = { "abc", "bce", "cae" };
        System.out.println(new DeleteColumnsToMakeSorted().minDeletionSize(strs));
    }

}
