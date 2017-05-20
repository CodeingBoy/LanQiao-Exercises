import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ALGO_117 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt(), num2 = scanner.nextInt();

        Integer[] approxNum1 = getApproxNum(num1);
        int sum1 = 0;
        for (int i : approxNum1) {
            sum1 += i;
        }
        if (sum1 != num2) {
            System.out.println("no");
            System.exit(0);
        }

        Integer[] approxNum2 = getApproxNum(num2);
        int sum2 = 0;
        for (int i : approxNum2) {
            sum2 += i;
        }
        if (sum2 != num1) {
            System.out.println("no");
            System.exit(0);
        }
        System.out.println("yes");

    }

    public static Integer[] getApproxNum(int num) {
        List<Integer> results = new ArrayList<>();
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                results.add(i);
            }
        }
        return results.toArray(new Integer[0]);
    }
}
