import java.util.Calendar;
import java.util.Scanner;

public class ALGO_105 {
    private static int YEAR_START = 1998;
    private static int WEEKDAY = 4;
    private static int[] daysOfMonth = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();

        int diffDaysCount = 0;
        for (int i = YEAR_START; i < year; i++) {
            diffDaysCount += 365;
            if (isLeapYear(i)) {
                diffDaysCount += 1;
            }
        }
        int weekday_Jan1 = (4 + diffDaysCount) % 7;

        System.out.println(countBlackFriday(year, weekday_Jan1));
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    private static int countBlackFriday(int year, int weekday_Jan1) {
        int count = 0;
        int dayOffset = 0;
        for (int i = 1; i <= 12; i++) {
            if ((weekday_Jan1 + dayOffset + 13 - 1) % 7 == 5) {
                count++;
            }

            dayOffset += daysOfMonth[i];
            if (i == 2 && isLeapYear(year)) {
                dayOffset += 1;
            }
        }
        return count;
    }
}
