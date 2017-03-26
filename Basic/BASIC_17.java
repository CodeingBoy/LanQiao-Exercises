import java.util.Scanner;

public class BASIC_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < result.length; i++) {
            result[i][i] = 1;
        }

        for (int i = 1; i <= m; i++) {
            result = matrix_multiple(result, matrix);
        }

        for (int[] is : result) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

    public static int[][] matrix_multiple(int[][] matrix1, int[][] matrix2) throws IllegalArgumentException {
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException();
        }

        int[][] result = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                for (int j2 = 0; j2 < matrix2.length; j2++) {
                    result[i][j] += matrix1[i][j2] * matrix2[j2][j];
                    // System.out.println(i + " " + j + ": " + matrix1[i][j2] +
                    // " + " + matrix2[j2][j]);
                }
            }
        }
        return result;
    }
}
