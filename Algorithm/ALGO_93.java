import java.util.Scanner;

public class ALGO_93 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int sum = reverseNumber(num1) + reverseNumber(num2);
        System.out.println(reverseNumber(sum));
    }

    public static int reverseNumber(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char digitTemp = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = chars[i];
            chars[i] = digitTemp;
        }

        int result = chars[0] - '0';
        for (int i = 1; i < chars.length; i++) {
            result *= 10;
            result += chars[i] - '0';
        }
        return result;
    }
}
