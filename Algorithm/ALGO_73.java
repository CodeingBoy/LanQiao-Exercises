import java.util.Scanner;

public class ALGO_73 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int digitCount = 0;
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digitCount++;
            }
        }
        System.out.println(digitCount);
    }
}
