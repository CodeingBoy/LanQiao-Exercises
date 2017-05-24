import java.util.Scanner;

public class ALGO_58 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String input = scanner.nextLine();
            System.out.println(new StringBuffer(input).reverse().toString());
        }
    }
}
