import java.util.Scanner;

public class BASIC_6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();

		// inital
		int[][] yanghuiTriangle = new int[row][row];
		for (int i = 0; i < row; i++) {
			yanghuiTriangle[i][0] = 1;
			yanghuiTriangle[i][i] = 1;
		}

		// calculate
		for (int i = 2; i < row; i++) {
			for (int j = 1; j < i; j++) {
					yanghuiTriangle[i][j] = yanghuiTriangle[i - 1][j - 1] + yanghuiTriangle[i - 1][j];
			}
		}

		// output
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < row; j++) {
				if (yanghuiTriangle[i][j] > 0) {
					System.out.print(yanghuiTriangle[i][j] + " ");
				}
			}
			System.out.println();
		}
	}
}
