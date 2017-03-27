import java.util.Scanner;

public class BASIC_26 {
    final static String[] NUM_ENGLISH = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen", "twenty" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = scanner.nextInt();
        int minute = scanner.nextInt();

        StringBuffer buffer = new StringBuffer();
        if (minute == 0) {
            if (hour < 20) {
                buffer.append(NUM_ENGLISH[hour] + " o'clock");
            } else {
                int one = hour % 10;
                if (one == 0) {
                    buffer.append("twenty o'clock");
                } else {
                    buffer.append("twenty " + NUM_ENGLISH[one] + " o'clock");
                }
            }
        } else {
            // hour
            if (hour < 20) {
                buffer.append(NUM_ENGLISH[hour] + " ");
            } else {
                int one = hour % 10;
                if (one == 0) {
                    buffer.append("twenty ");
                } else {
                    buffer.append("twenty " + NUM_ENGLISH[one] + " ");
                }
            }

            // minute
            if (minute <= 20) {
                buffer.append(NUM_ENGLISH[minute] + " ");
            } else {
                int ten = minute / 10;
                int one = minute % 10;
                switch (ten) {
                case 2:
                    buffer.append("twenty ");
                    break;
                case 3:
                    buffer.append("thirty ");
                    break;
                case 4:
                    buffer.append("forty ");
                    break;
                case 5:
                    buffer.append("fifty ");
                    break;
                }
                if (one != 0) {
                    buffer.append(NUM_ENGLISH[one]);
                }
            }
        }
        System.out.println(buffer.toString().trim());
    }
}
