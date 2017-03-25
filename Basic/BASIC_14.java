import java.util.Scanner;

public class BASIC_14 {
    static final int MINUTE_SECONDS = 60;
    static final int HOUR_SECONDS = 60 * MINUTE_SECONDS;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int time_second = scanner.nextInt();

        int hours = time_second / HOUR_SECONDS;
        int minutes = (time_second - (hours * HOUR_SECONDS)) / MINUTE_SECONDS;
        int seconds = time_second % MINUTE_SECONDS;

        System.out.printf("%d:%d:%d", hours, minutes, seconds);
    }
}
