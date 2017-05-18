import java.util.Scanner;

public class ALGO_71 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        words[0] = words[0] + "\0";
        words[1] = words[1] + "\0";

        char[] chars_1 = words[0].toCharArray();
        char[] chars_2 = words[1].toCharArray();

        int curPos = 0;
        while (curPos < chars_1.length && curPos < chars_2.length) {
            if (chars_1[curPos] != chars_2[curPos]) {
                System.out.println(chars_1[curPos] - chars_2[curPos]);
                System.exit(0);
            }
            curPos++;
        }

        System.out.println("0");
    }
}
