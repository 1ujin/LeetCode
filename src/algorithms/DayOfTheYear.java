package algorithms;

public class DayOfTheYear {

    private final static int[] DAYS = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int dayOfYear(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8));
        int result = 0;
        for (int i = 0; i < month - 1; i++)
            result += DAYS[i];
        if (month > 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)))
            result++;
        result += day;
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new DayOfTheYear().dayOfYear("2020-12-31"));
    }

}
