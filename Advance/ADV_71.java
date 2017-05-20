import java.util.Scanner;

public class ADV_71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();

        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                System.out.println("no!");
                System.exit(0);
            }
        }
        System.out.println("yes!");
    }
}
