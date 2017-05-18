import java.util.Scanner;

public class ALGO_78 {
    private static char[] VOWELS = { 'a', 'e', 'i', 'o', 'u' };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();

        int vowelPos = 0;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            for (char v : VOWELS) {
                if (c == v) {
                    vowelPos = i + 1;
                    break;
                }
            }
            if (vowelPos != 0) {
                break;
            }
        }

        System.out.println(vowelPos);
    }
}
