import java.util.Scanner;

public class ALGO_72 {
    private static String[] GRADE = { "E", "E", "E", "E", "E", "E", "D", "C", "B", "A", "A" };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double score = scanner.nextDouble();

        System.out.println(GRADE[(int) (score / 10)]);
    }
}
