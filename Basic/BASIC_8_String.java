
public class BASIC_8_String {
	public static void main(String[] args) {
		for (int i = 1000; i < 10000; i++) {
			if (isRepeatNum(i)) {
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
}
