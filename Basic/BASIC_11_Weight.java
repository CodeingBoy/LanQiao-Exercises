import java.util.Scanner;

public class BASIC_11_Weight {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		String hexNum = scanner.next();

		System.out.println(toDec(hexNum));
	}

	public static long toDec(String hexNum) {
		long decNum = 0;

		int curPow = 0;
		for (int i = hexNum.length() - 1; i >= 0; i--) {
			char hexDigit = hexNum.charAt(i);
			int decDigit = 0;
			if (Character.isDigit(hexDigit)) {
				decDigit = Integer.valueOf(hexDigit + "");
			} else {
				decDigit = hexDigit - 'A' + 10;
			}
			decNum += decDigit * Math.pow(16, curPow);
			curPow++;
		}

		return decNum;
	}
}
