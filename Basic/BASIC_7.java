
public class BASIC_7 {
	public static void main(String[] args) {
		for (int i = 100; i < 1000; i++) {
			if (isNarcissisticNumber(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isNarcissisticNumber(int num) {
		int sum = 0, num_temp = num;
		while (num_temp != 0) {
			int digit = num_temp % 10;
			sum += Math.pow(digit, 3);
			num_temp /= 10;
		}
		return sum == num;
	}
}
