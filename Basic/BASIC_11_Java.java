import java.util.Scanner;

public class BASIC_11_Java {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String hexNum = scanner.next();

		System.out.println(Long.valueOf(hexNum, 16));
	}
}
