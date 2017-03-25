import java.util.Scanner;

public class BASIC_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String a = scanner.nextLine();
        String b = scanner.nextLine();

        if (a.length() != b.length()) {
            System.out.println("1");
        } else if (a.equals(b)) {
            System.out.println("2");
        } else if (a.toUpperCase().equals(b.toUpperCase())) {
            System.out.println("3");
        } else {
            System.out.println("4");
        }
    }
}
