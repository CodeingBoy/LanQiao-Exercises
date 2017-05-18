import java.util.Scanner;

public class ALGO_118 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int n = scanner.nextInt();

        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                int middleNum = n / i;
                int numCount = n / middleNum;
                if (numCount == 1 || (middleNum - numCount / 2) < 1 || (middleNum + numCount / 2) > n)
                    continue;
                if (numCount % 2 == 1) {
                    System.out.println((middleNum - numCount / 2) + " " + (middleNum + numCount / 2));
                } else {

                }
                continue;
            }
            if (((double) n / i) % 0.5 == 0) {
                int middleNum = n / i;
                int numCount = (int) (n / ((double) n / i));
                if (numCount == 1 || (middleNum - numCount / 2) < 1 || (middleNum + numCount / 2) > n)
                    continue;
                if (numCount % 2 == 0 && calcSum((middleNum - numCount / 2 + 1), (middleNum + numCount / 2)) == n) {
                    System.out.println((middleNum - numCount / 2 + 1) + " " + (middleNum + numCount / 2));
                    continue;
                }
            }

        }
        System.out.println(calcSum(11, 16));
    }

    public static int calcSum(int start, int end) {
        int sum;
        sum = (end - start + 1) / 2 * (end + start);
        if ((end - start + 1) % 2 != 0) {
            sum += start + (end - start + 1) / 2;
        }
        return sum;
    }
}
