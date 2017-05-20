import java.util.Scanner;

public class ALGO_48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nodeCount = scanner.nextInt(), edgeCount = scanner.nextInt();

        int[][] graph = new int[nodeCount][edgeCount];

        for (int i = 1; i <= edgeCount; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a - 1][i - 1] += 1;
            graph[b - 1][i - 1] -= 1;
        }

        for (int[] is : graph) {
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
