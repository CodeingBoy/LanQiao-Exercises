import java.util.Scanner;

public class ALGO_147 {
    public static void main(String[] args) {
        for (int i = 100; i < 1000; i++) {
            int num = i;
            int result = 0;
            while (num > 0) {
                int digit = num % 10;
                result += Math.pow(digit, 3);
                num /= 10;
            }
            if (result == i) {
                System.out.println(i);
            }
        }
    }
}
