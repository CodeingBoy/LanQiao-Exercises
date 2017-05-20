import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ALGO_19 {
    private static class Status {
        int sum;
        List<Position> positions;

        public Status() {
            sum = 0;
            positions = new ArrayList<>();
        }

        public Status(int sum) {
            this.sum = sum;
            this.positions = new ArrayList<>();
        }

    }

    private static class Position {
        int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] graph = new int[n + 1][n + 1];

        while (true) {
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            int num = scanner.nextInt();
            if (row == 0 && col == 0 && num == 0) {
                break;
            }

            graph[row][col] = num;
        }

        // test code
        for (int[] is : graph) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        Status firstResult = getMaxSum(graph, n, n);
        // System.out.println(firstResult.sum);
        for (Position i : firstResult.positions) {
            // System.out.println(i.x + " " + i.y);
            graph[i.x][i.y] = 0;
        }

        // test code
        for (int[] is : graph) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        Status secondResult = getMaxSum(graph, n, n);
        // System.out.println(secondResult.sum);
        System.out.println(firstResult.sum + secondResult.sum);
    }

    public static Status getMaxSum(int[][] graph, int row, int col) {
        if (col <= 0 || row <= 0) {
            return new Status(0);
        }

        Status status;

        Status statusA = getMaxSum(graph, row - 1, col);
        Status statusB = getMaxSum(graph, row, col - 1);

        if (statusA.sum > statusB.sum) {
            status = statusA;
        } else if (statusA.sum < statusB.sum) {
            status = statusB;
        } else {
            if (statusA.positions.size() > statusB.positions.size()) {
                status = statusA;
            } else {
                status = statusB;
            }
        }
        status.sum += graph[row][col];
        status.positions.add(new Position(row, col));

        return status;
    }

}
