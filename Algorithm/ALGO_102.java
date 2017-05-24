import java.util.Scanner;

public class ALGO_102 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int num = scanner.nextInt();
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    System.out.printf("%d * %d = %d\n", i, num / i, num);
                }
            }
        }
    }
}
