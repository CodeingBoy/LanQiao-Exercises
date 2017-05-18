import java.math.BigInteger;
import java.util.Scanner;

public class ALGO_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numString = scanner.nextLine();
        BigInteger num = new BigInteger(numString);
        BigInteger numMinus1 = num.subtract(new BigInteger("1"));
        BigInteger numMinus2 = num.subtract(new BigInteger("2"));
        BigInteger numMinus3 = num.subtract(new BigInteger("3"));

        if (num.mod(new BigInteger("2")).equals(new BigInteger("1"))) {
            System.out.println(num.multiply(numMinus1).multiply(numMinus2));
        } else {
            if (!num.mod(new BigInteger("3")).equals(new BigInteger("0"))){
                System.out.println(num.multiply(numMinus1).multiply(numMinus3));
            }else{
                System.out.println(numMinus1.multiply(numMinus2).multiply(numMinus3));
            }
        }
    }
}
