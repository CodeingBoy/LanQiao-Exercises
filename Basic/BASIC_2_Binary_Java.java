
public class BASIC_2_Binary_Java {
	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {
			String binaryString = Integer.toBinaryString(i);
			while(binaryString.length() < 5){
				binaryString = "0" + binaryString;
			}
			System.out.println(binaryString);
		}
	}
}
