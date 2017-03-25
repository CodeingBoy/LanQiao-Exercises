import java.util.Scanner;

public class BASIC_1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();

		if (isLeapYear(year)) {
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}

	public static boolean isLeapYear(int year) {
		if (year % 4 == 0 && year % 100 != 0)
			return true;
		if (year % 400 == 0)
			return true;
		return false;
	}

}
