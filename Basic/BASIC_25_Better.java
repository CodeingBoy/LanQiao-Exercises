import java.util.Scanner;

// Note: This answer may cause timeout

public class BASIC_25_Better {
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
        int left = 0, right = colCount - 1, up = 0, bottom = rowCount - 1;

        while (true) {
            if (curRow >= rowCount || curRow < 0 || curCol < 0 || curCol >= colCount) {
                break;
            }
            if (!read[curRow][curCol]) {
                System.out.print(matrix[curRow][curCol] + " ");
                read[curRow][curCol] = true;
            }

            // System.out.println("cur: " + curRow + "," + curCol + " new:"
            // + newRow + "," + newCol);

            if (left >= right && up >= bottom) {
                if (left == right && up == bottom && !read[left][up]) {
                    System.out.println(matrix[left][up]);
                }
                break;
            }

            if (direction == 0 && curCol == left && curRow == bottom) {
                direction = 1;
                left++;
            }
            if (direction == 2 && curCol == left && curRow == up) {
                direction = 0;
                up++;
            }
            if (direction == 1 && curCol == right && curRow == bottom) {
                direction = 3;
                bottom--;
            }
            if (direction == 3 && curCol == right && curRow == up) {
                direction = 2;
                right--;
            }

            curRow = curRow + delta[direction][0];
            curCol = curCol + delta[direction][1];
        }

    }
}
