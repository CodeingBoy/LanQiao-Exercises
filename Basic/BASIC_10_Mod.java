import java.util.Scanner;

public class BASIC_10_Mod {
	final static char[] HEX_DIGIT = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int decNum = scanner.nextInt();

		System.out.println(toHex(decNum));
	}

	public static String toHex(int decNum) {
		StringBuffer buffer = new StringBuffer();
		do {
			int decDigit = decNum % 16;
			buffer.insert(0, HEX_DIGIT[decDigit]);
			decNum /= 16;
		} while (decNum > 0);
		return buffer.toString();
	}

}
