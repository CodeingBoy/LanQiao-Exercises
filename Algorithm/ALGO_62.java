import java.util.Scanner;

public class ALGO_62 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println((a % m) * (a % m) % m);
    }
}
