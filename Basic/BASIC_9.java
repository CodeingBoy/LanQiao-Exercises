import java.util.Scanner;

public class BASIC_9 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int expectSum = scanner.nextInt();

		for (int i = 10000; i < 1000000; i++) {
			if (isRepeatNum(i) && calcSum(i) == expectSum) {
				System.out.println(i);
			}
		}
	}

	public static boolean isRepeatNum(int num) {
		String string = String.valueOf(num);

		int length = string.length();
		for (int i = 0; i < length / 2; i++) {
			char left = string.charAt(i);
			char right = string.charAt(length - 1 - i);
			if (left != right) {
				return false;
			}
		}
		return true;
	}

	public static int calcSum(int num) {
		int sum = 0;
		while (num != 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
