package algorithms;

public class ExcelSheetColumnTitle {
    
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber-- > 0) {
            int c = columnNumber % 26;
            sb.append((char) (c + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(-1 >>> 1));
    }

}
