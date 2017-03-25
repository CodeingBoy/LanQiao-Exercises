import java.util.Scanner;

public class BASIC_12_Manual {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numCount = scanner.nextInt();

		while (numCount > 0) {
			String hexNum = scanner.next();

			String binNum = hex2Bin(hexNum);
			// System.out.println(binNum);
			String octNum = bin2Oct(binNum);

			System.out.println(octNum);
			numCount--;
		}

	}

	private static String bin2Oct(String binNum) {
		StringBuffer buffer = new StringBuffer();

		while (binNum.length() % 3 != 0) {
			binNum = "0" + binNum;
		}

		// System.out.println(binNum);
		// for (int i = binNum.length() - 3; i >= 0; i -= 3) {
		for (int i = 0; i < binNum.length(); i += 3) {
			// String block = binNum.substring(i, i + 3);

			// int digit_3 = block.charAt(0) - '0';
			// int digit_2 = block.charAt(1) - '0';
			// int digit_1 = block.charAt(2) - '0';

			int digit_3 = binNum.charAt(i) - '0';
			int digit_2 = binNum.charAt(i + 1) - '0';
			int digit_1 = binNum.charAt(i + 2) - '0';

			int octDigit = digit_3 * 4 + digit_2 * 2 + digit_1 * 1;
			// buffer.insert(0, octDigit);
			buffer.append(octDigit);
		}

		String result = buffer.toString();
		while (result.startsWith("0")) {
			result = result.substring(1, result.length());
		}

		return result;
	}

	private static String hex2Bin(String hexNum) {
		final String[] HEX2BIN = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001",
				"1010", "1011", "1100", "1101", "1110", "1111" };

		StringBuffer buffer = new StringBuffer();
		// for (int i = hexNum.length() - 1; i >= 0; i--) {
		for (int i = 0; i < hexNum.length(); i++) {
			char hexChar = hexNum.charAt(i);
			int hexDigit = Character.isDigit(hexChar) ? Integer.valueOf(hexChar + "") : hexChar - 'A' + 10;

			buffer.append(HEX2BIN[hexDigit]);

			// buffer.insert(0, HEX2BIN[hexDigit]);

			// int insertedCount = 0;
			// // StringBuffer blockBuffer = new StringBuffer();
			// do {
			// // blockBuffer.insert(0, hexDigit % 2);
			// buffer.insert(0, hexDigit % 2);
			// insertedCount++;
			// hexDigit /= 2;
			// } while (hexDigit > 0);
			// // if (blockBuffer.length() < 4) {
			// // blockBuffer.insert(0, "0");
			// // }
			// // buffer.insert(0, blockBuffer);
			// while (insertedCount < 4) {
			// buffer.insert(0, "0");
			// insertedCount++;
			// }
		}

		return buffer.toString();
	}
}
