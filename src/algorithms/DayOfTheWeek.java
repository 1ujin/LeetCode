package algorithms;

public class DayOfTheWeek {

    public String dayOfTheWeek(int day, int month, int year) {
        String[] weekDate = { "Sunday", "Monday", "Tuesday", "Wednesday",
                "Thursday", "Friday", "Saturday" };
        int[] monthDays = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30 };
        for (int i = 1; i < 12; i++)
            monthDays[i] += monthDays[i - 1];
        int days = (year - 1971) * 365 + monthDays[month - 1] + day + 4;
        int leaps = (year - 1969) / 4;
        if (month > 2 && (year % 1000 == 0 || year % 4 == 0 && year % 100 != 0))
            leaps++;
        return weekDate[(days + leaps) % 7];
    }

    public static void main(String[] args) {
        System.out.println(new DayOfTheWeek().dayOfTheWeek(2100, 12, 31));
    }

}
