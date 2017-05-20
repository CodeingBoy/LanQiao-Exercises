import java.util.Scanner;

public class ALGO_64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);

        if (c >= 'A' && c <= 'Z') {
            System.out.println("upper");
        } else {
            System.out.println("lower");
        }
    }
}
