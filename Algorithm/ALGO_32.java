import java.util.Scanner;

public class ALGO_32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minChar = scanner.nextInt() - 1;
        int maxChar = scanner.nextInt() - 1;
        int width = scanner.nextInt();
        scanner.nextLine();
        String curJam = scanner.nextLine();

        System.out.println(getNextJam(curJam, (char) ('a' + minChar), (char) ('a' + maxChar), width));
    }

    public static String getNextJam(String curJam, char minChar, char maxChar, int width) {
        char[] chars = curJam.toCharArray();
        int[] add = new int[width];
        add[width - 1] = 1;

        for (int i = width - 1; i >= 0; i--) {
            chars[i] += add[i];
            if (i < width - 1 && chars[i] == chars[i + 1]) {
                chars[i]++;
            }
            if (chars[i] > maxChar) {
                chars[i] = (char) (chars[i] - maxChar + chars[i - 1]);
                add[i - 1] += 1;
            }
        }

        return new String(chars);
    }
}
