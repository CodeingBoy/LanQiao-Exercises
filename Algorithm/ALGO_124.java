import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;

public class ALGO_124 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lineCount = scanner.nextInt();
        scanner.nextLine(); // ignore next \n

        int[][] triangle = new int[lineCount][lineCount];
        int[][] result = new int[lineCount][lineCount];
        for (int[] is : triangle) {
            Arrays.setAll(is, new IntUnaryOperator() {

                @Override
                public int applyAsInt(int operand) {
                    // TODO Auto-generated method stub
                    return -1;
                }
            });
        }
        for (int[] resultRow : result) {
            Arrays.setAll(resultRow, new IntUnaryOperator() {

                @Override
                public int applyAsInt(int operand) {
                    // TODO Auto-generated method stub
                    return -1;
                }
            });
        }

        for (int i = 0; i < lineCount; i++) {
            String line = scanner.nextLine();
            String[] nums_str = line.split(" ");
            for (int j = 0; j < nums_str.length; j++) {
                String string = nums_str[j];
                if (string.isEmpty())
                    continue;
                triangle[i][j] = Integer.parseInt(string);
            }
        }
        
        System.out.println(dp(0, 0, triangle, result));

    }

    public static int dp(int row, int col, int[][] triangle, int[][] result) {
        if (row >= triangle.length || col >= triangle.length) {
            return 0;
        }
        if (result[row][col] != -1) {
            return result[row][col];
        }

        int left = dp(row + 1, col, triangle, result);
        int right = dp(row + 1, col + 1, triangle, result);
        int max = Math.max(left, right);
        result[row][col] = max + triangle[row][col];
        return result[row][col];
    }
}
