import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ALGO_82 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        char[][] matrix = new char[2 * n - 1][2 * n - 1];
        for (char[] cs : matrix) {
            Arrays.fill(cs, '.');
        }

        int mid = n - 1;
        char centerChar = (char) ('A' + n - 1);
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[mid][i] = (char) (centerChar - Math.abs(mid - i));
            matrix[i][mid] = (char) (centerChar - Math.abs(mid - i));
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = (char) (centerChar - Math.abs(mid - i));
            matrix[i][matrix[i].length - 1 - i] = (char) (centerChar - Math.abs(mid - i));
        }

        for (char[] cs : matrix) {
            for (char c : cs) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
