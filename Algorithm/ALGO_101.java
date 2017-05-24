import java.util.Scanner;

public class ALGO_101 {
    private static String UNIT = "* ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCount = scanner.nextInt();

        for (int i = rowCount; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(UNIT);
            }
            System.out.println();
        }
    }
}
