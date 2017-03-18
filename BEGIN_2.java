import java.math.BigInteger;
import java.util.Scanner;

public class BEGIN_2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		BigInteger sum = new BigInteger(String.valueOf(1 + n));
		sum = sum.multiply(new BigInteger(String.valueOf(n / 2)));
		if (n % 2 != 0) {
			sum = sum.add(new BigInteger(String.valueOf((int)Math.ceil((double)n / 2))));
		}
		System.out.println(sum);
	}
}
