import java.util.Scanner;

public class BASIC_22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println(getAString(n));
    }

    public static String getAString(int n) {
        if (n == 1) {
            return "A";
        }
        String formerString = getAString(n - 1);
        return formerString + (char)('A' + n - 1) + formerString;
    }
}
