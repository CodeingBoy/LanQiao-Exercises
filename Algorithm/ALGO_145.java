import java.util.Scanner;

public class ALGO_145 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineCount = scanner.nextInt();

        int width = (lineCount - 1) * 2 + 1;
        for (int i = 0; i < lineCount; i++) {
            StringBuffer buffer = new StringBuffer();
            int spaceCount = lineCount - i - 1;
            int starCount = width - spaceCount * 2;
            int pos = 0;
            for (; pos < spaceCount; pos++) {
                buffer.append(" ");
            }
            for (; pos < spaceCount + starCount; pos++) {
                buffer.append("*");
            }
            for (; pos < width; pos++) {
                buffer.append(" ");
            }
            System.out.println(buffer);
        }

    }
}
