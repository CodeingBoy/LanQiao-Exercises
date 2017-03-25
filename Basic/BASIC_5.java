import java.util.Scanner;

public class BASIC_5 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int numCount = scanner.nextInt();

		int[] nums = new int[numCount];
		for (int i = 0; i < numCount; i++) {
			nums[i] = scanner.nextInt();
		}

		int pattern = scanner.nextInt();

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == pattern) {
				System.out.println(i + 1);
				System.exit(0);
			}
		}
		System.out.println("-1");
	}
}
