import java.util.Scanner;

public class ALGO_17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numLength = scanner.nextInt();
        int operCount = scanner.nextInt();
        String num = scanner.next();

        System.out.println(calcMaxProduct(num, operCount));
    }

    public static int calcMaxProduct(final String num, int operCount) {
        if (operCount <= 0 || num.length() < 2) {
            if (operCount == 0) {
                return Integer.valueOf(num);
            } else {
                return Integer.MIN_VALUE;
            }
        }
        if (num.length() == 2) {
            if (operCount == 1) {
                return Integer.valueOf(num.charAt(0) - '0') * Integer.valueOf(num.charAt(1) - '0');
            } else {
                return Integer.MIN_VALUE;
            }
        }

        int maxVal = Integer.MIN_VALUE;
        for (int i = 1; i < num.length(); i++) {
            String left = num.substring(0, i);
            String right = num.substring(i, num.length());
            int rightMax = calcMaxProduct(right, operCount - 1);
            int product = Integer.valueOf(left) * rightMax;
            //System.out.printf("left %s, right %d, product %d\n", left, rightMax, product);
            if (product >= maxVal) {
                maxVal = product;
            }
        }
        return maxVal;
    }
}
