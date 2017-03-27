import java.util.Scanner;

//Note: This answer may cause timeout

public class BASIC_25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowCount = scanner.nextInt();
        int colCount = scanner.nextInt();

        int[][] matrix = new int[rowCount][colCount];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int curRow = 0, curCol = 0;
        int direction = 0;
        int[][] delta = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
        boolean[][] read = new boolean[rowCount][colCount];

        while (true) {
            if (!read[curRow][curCol]) {
                System.out.print(matrix[curRow][curCol] + " ");
                read[curRow][curCol] = true;
            }

            int newRow, newCol;
            int tryTime = 0;
            do {
                newRow = curRow + delta[direction][0];
                newCol = curCol + delta[direction][1];
                // System.out.println("cur: " + curRow + "," + curCol + " new:"
                // + newRow + "," + newCol);
                if (newRow > rowCount - 1 || newRow < 0 || newCol > colCount - 1 || newCol < 0
                        || read[newRow][newCol]) {
                    direction = (direction + 1) % 4;
                    tryTime++;
                }
                if (tryTime == 4) {
                    break;
                }
            } while (newRow > rowCount - 1 || newRow < 0 || newCol > colCount - 1 || newCol < 0
                    || read[newRow][newCol]);

            curRow = newRow;
            curCol = newCol;
            if (tryTime == 4) {
                break;
            }
        }

    }
}
