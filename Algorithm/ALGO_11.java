import java.util.Scanner;

public class ALGO_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        System.out.println(calcWays(0, length));
    }

    public static int calcWays(int start, int end) {
        if (start == end)
            return 1;
        else if (start > end) {
            return 0;
        }

        return calcWays(start + 1, end) + calcWays(start + 2, end);
    }
}
