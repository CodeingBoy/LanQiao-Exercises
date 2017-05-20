import java.util.Scanner;

public class ALGO_119 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] haveNum = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            int num = calcNum(i);
            if (num <= n) {
                haveNum[num] = true;
            }
        }

        for (int i = 1; i < haveNum.length; i++) {
            if (!haveNum[i]) {
                System.out.println(i);
            }
        }
    }

    public static int calcNum(int n) {
        int digitSum = 0;
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            temp /= 10;
            digitSum += digit;
        }
        return digitSum + n;
    }
}
