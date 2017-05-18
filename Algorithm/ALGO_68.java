import java.util.Scanner;

public class ALGO_68 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        for (char c : string.toCharArray()) {
            if (c >= '0' && c <= '9') {
                continue;
            }
            System.out.println("no");
            System.exit(0);
        }
        System.out.println("yes");
    }
}
