
public class BASIC_2_Binary {
	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {
			System.out.println(getBinary(i));
		}
	}

	public static String getBinary(int decNum) {
		StringBuffer buffer = new StringBuffer();
		while (decNum != 0) {
			int digit = decNum % 2;
			buffer.insert(0, String.valueOf(digit));
			decNum /= 2;
		}
		
		while(buffer.length() < 5){
			buffer.insert(0, String.valueOf(0));
		}
		
		return buffer.toString();
	}
}
