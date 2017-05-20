import java.util.Scanner;

public class ALGO_104 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();

        System.out.println(calcAlphaProduct(num));
    }

    public static long calcAlphaProduct(long num) {
        if (num >= 0 && num < 10)
            return num;

        int product = 1;
        while (num > 0) {
            int digit = (int) (num % 10);
            num /= 10;
            if (digit == 0)
                continue;
            product *= digit;
        }

        return calcAlphaProduct(product);
    }
}
