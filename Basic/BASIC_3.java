import java.util.Scanner;

public class BASIC_3 {
	final static String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int row = scanner.nextInt();
		int col = scanner.nextInt();

		String line = ALPHABET.substring(0, col);
		System.out.println(line);
		row--;

		int curIndex = 1;
		while (row > 0) {
			line = (char)ALPHABET.charAt(curIndex) + line;
			line = line.substring(0, col);
			System.out.println(line);
			curIndex++;
			row--;
		}
	}
}
