import java.util.Scanner;

public class BASIC_4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numCount = scanner.nextInt();

		int max = -10000;
		int min = 10000;
		int sum = 0;

		for (int i = 0; i < numCount; i++) {
			int num = scanner.nextInt();
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
			sum += num;
		}
		System.out.println(max);
		System.out.println(min);
		System.err.println(sum);
	}
}
