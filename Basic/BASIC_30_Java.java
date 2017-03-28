import java.math.BigInteger;
import java.util.Scanner;

public class BASIC_30_Java {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        BigInteger result = new BigInteger("1");

        for (int i = 1; i <= num; i++) {
            result = result.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println(result);
    }
}
