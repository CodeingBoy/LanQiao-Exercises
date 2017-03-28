import java.util.Scanner;

public class BASIC_27 {
    static int wayCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] graph = new int[n][n];
        boolean[][] placeable = new boolean[n][n];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                placeable[i][j] = scanner.nextInt() == 1;
            }
        }

        select_black(graph, placeable, 0);

        System.out.println(wayCount);
    }

    public static void select_black(int[][] graph, boolean[][] placeable, int row) {
        if (row >= graph.length) {
            //wayCount++;

//            for (int[] curRow : graph) {
//                for (int curCol : curRow) {
//                    System.out.print(curCol + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            select_white(graph, placeable, 0);

            return;
        }

        for (int i = 0; i < graph[row].length; i++) {
            if (!placeable[row][i]) {
                continue;
            }

            boolean haveConflict = false;
            for (int j = 0; j < row; j++) {
                if (graph[j][i] == 1) {
                    haveConflict = true;
                    break;
                }
            }

            if (haveConflict)
                continue;

            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].length; k++) {
                    if (j - k == row - i) {
                        if (graph[j][k] == 1) {
                            haveConflict = true;
                            break;
                        }
                    }

                    if (j + k == row + i) {
                        if (graph[j][k] == 1) {
                            haveConflict = true;
                            break;
                        }
                    }
                }
            }
            if (haveConflict)
                continue;

            graph[row][i] = 1;
            select_black(graph, placeable, row + 1);
            graph[row][i] = 0;
        }
    }

    public static void select_white(int[][] graph, boolean[][] placeable, int row) {
        if (row >= graph.length) {
            wayCount++;

//            for (int[] curRow : graph) {
//                for (int curCol : curRow) {
//                    System.out.print(curCol + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            return;
        }

        for (int i = 0; i < graph[row].length; i++) {
            if (!placeable[row][i] || graph[row][i] != 0) {
                continue;
            }

            boolean haveConflict = false;
            for (int j = 0; j < row; j++) {
                if (graph[j][i] == 2) {
                    haveConflict = true;
                    break;
                }
            }

            if (haveConflict)
                continue;

            for (int j = 0; j < graph.length; j++) {
                for (int k = 0; k < graph[j].length; k++) {
                    if (j - k == row - i) {
                        if (graph[j][k] == 2) {
                            haveConflict = true;
                            break;
                        }
                    }

                    if (j + k == row + i) {
                        if (graph[j][k] == 2) {
                            haveConflict = true;
                            break;
                        }
                    }
                }
            }
            if (haveConflict)
                continue;

            graph[row][i] = 2;
            select_white(graph, placeable, row + 1);
            graph[row][i] = 0;
        }
    }
}
