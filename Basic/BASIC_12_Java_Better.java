import java.util.Scanner;

public class BASIC_12_Java_Better {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numCount = scanner.nextInt();

        while (numCount > 0) {
            String hexNum = scanner.next();
            StringBuffer buffer = new StringBuffer();

            while (hexNum.length() % 3 != 0) {
                hexNum = "0" + hexNum;
            }

            for (int i = 0; i < hexNum.length(); i += 3) {
                String block = hexNum.substring(i, i + 3);
                String octNum = Integer.toOctalString(Integer.parseInt(block, 16));
                while (octNum.length() < 4) {
                    octNum = "0" + octNum;
                }
                buffer.append(octNum);
            }

            String result = buffer.toString();
            while (result.startsWith("0")) {
                result = result.substring(1, result.length());
            }

            System.out.println(result);
            numCount--;
        }
    }
}
