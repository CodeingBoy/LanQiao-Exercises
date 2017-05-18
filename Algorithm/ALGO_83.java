import java.util.Scanner;

public class ALGO_83 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 1; i <= n; i++)
            System.out.println(i + ": " + calcLastDigit(i));
    }

    public static int calcLastDigit(int n) {
        // 1! = 1 1
        // 2! = 2 2
        // 3! = 6 6
        // 4! = 24 4
        // 5! = 120 2
        // 6! = 720 = 120 * 6 = 72 2
        // 7! = 5040 = 720 * 7 = 72 * 7 4
        // 8! = 40320 = 504 * 8 2
        // 9! = 362880 = 4032 * 9 8
        // 10! = 3628800 = 36288 * 10 8
        // 11! = 39916800 = 36288 * 11 8
        // 12! = 479001600 = 8 * 12 6
        // 13! = 6227020800 8
        // 14! = 87178291200 2
        // 15! = 1307674368000 8
        int digit = 1;
        for (int i = 2; i <= n; i++) {
            digit = digit * i;
            while (digit % 10 == 0) {
                digit /= 10;
            }
            digit %= 10;
            // System.out.println(i + "-" + digit);
        }
        return digit % 10;
    }
}
