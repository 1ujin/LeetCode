package algorithms;

public class ExcelSheetColumnNumber {

    public int titleToNumber(String columnTitle) {
        int columnNumber = 0;
        for (char c : columnTitle.toCharArray())
            columnNumber = columnNumber * 26 + c - 'A' + 1;
        return columnNumber;
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZY"));
    }

}
