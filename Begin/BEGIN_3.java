import java.util.Scanner;

public class BEGIN_3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int r = scanner.nextInt();

		double s = Math.PI * Math.pow(r, 2);

		System.out.printf("%.7f", s);
	}
}
