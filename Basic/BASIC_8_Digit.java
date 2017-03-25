
public class BASIC_8_Digit {
	public static void main(String[] args) {
		for (int i = 1000; i < 10000; i++) {
			if (isRepeatNum(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isRepeatNum(int num) {
		int[] digits = new int[4];
		
		int curIndex = 0;
		while(num != 0){
			digits[curIndex] = num % 10;
			curIndex++;
			num /= 10;
		}
		
		return digits[0] == digits[3] && digits[1] == digits[2];
	}
}
