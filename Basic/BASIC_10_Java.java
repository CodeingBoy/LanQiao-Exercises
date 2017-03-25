import java.util.Scanner;

public class BASIC_10_Java {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int decNum = scanner.nextInt();

		System.out.println(Integer.toHexString(decNum).toUpperCase());
	}
}
