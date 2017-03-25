import java.util.Scanner;

public class BASIC_12_Java_Binary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int numCount = scanner.nextInt();

		while (numCount > 0) {
			String hexNum = scanner.next();
			StringBuffer buffer = new StringBuffer();

			int i = hexNum.length();
			for (i = hexNum.length() - 3; i >= 0; i -= 3) {
				String block = hexNum.substring(i, i + 3);
				String binNum = Integer.toBinaryString(Integer.parseInt(block, 16));
				String octNum = Integer.toOctalString(Integer.valueOf(binNum, 2));
				while (octNum.length() < 4) {
					octNum = "0" + octNum;
				}
				buffer.insert(0, octNum);

			}

			if (i != -3) {
				i += 3;
				String block = hexNum.substring(0, i);
				String binNum = Integer.toBinaryString(Integer.parseInt(block, 16));
				String octNum = Integer.toOctalString(Integer.valueOf(binNum, 2));
				while (octNum.length() < 4) {
					octNum = "0" + octNum;
				}
				buffer.insert(0, octNum);
			}

			String result = buffer.toString();
			while (result.startsWith("0")) {
				result = result.substring(1, result.length());
			}

			System.out.println(result);
			numCount--;
		}

	}

}
