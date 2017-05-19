import java.util.Scanner;

public class ALGO_83 {
    private static int[] DICT = { 0, 1, 2, 6, 4, 2, 2, 4, 2, 8, 8, 8, 6, 8, 2, 8, 8, 6, 8, 2, 4, 4, 8, 4, 6, 4, 4, 8, 4,
            6, 8, 8, 6, 8, 2, 2, 2, 4, 2, 8, 2, 2, 4, 2, 8, 6, 6, 2, 6, 4, 7, 7, 4, 2, 8, 4, 4, 8, 4, 6, 6, 6, 2, 6, 4,
            6, 6, 2, 6, 4, 8, 8, 6, 8, 2, 4, 4, 8, 4, 6, 8, 8, 6, 8, 2, 2, 2, 4, 2, 8, 2, 2, 4, 2, 8, 6, 6, 2, 6, 4,
            4, };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // System.out.println(calcLastDigit(n));
        // System.out.println(generateTable(100));
        System.out.println(DICT[n]);
    }

    public static String generateTable(int n) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 1; i <= n; i++) {
            buffer.append(calcLastDigit(i) + ", ");
        }
        return buffer.toString();
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
        // 16! = 20922789888000 8
        // 17! = 355687428096000 6
        // 24! = 620448401733239439360000 6 6 * 25 = 150
        // 25! = 15511210043330985984000000 4
        int digit = 1;
        for (int i = 2; i <= n; i++) {
            int lastDigit = digit % 10;
            int result = lastDigit * i;
            while (result % 10 == 0) {
                result /= 10;
                digit /= 10;
                result += (digit % 10) * i;
            }
            digit = result % 100000;
            // System.out.println(i + "-" + digit);
        }
        return digit % 10;
    }
}
