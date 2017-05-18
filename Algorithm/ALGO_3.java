import java.util.Scanner;

public class ALGO_3 {
    private static long[][] resultSheet;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int radix = scanner.nextInt();
        int digitCount = scanner.nextInt();

        resultSheet = new long[digitCount + 1][radix];
        for (int i = 0; i < resultSheet.length; i++) {
            for (int j = 0; j < resultSheet[i].length; j++) {
                resultSheet[i][j] = -1;
            }
        }

        int total = 0;
        for (int i = 1; i < radix; i++) {
            total += calcPossibility(1, digitCount - 1, radix, i);
            total %= 1000000007;
        }
        //total -= calcPossibility(1, digitCount - 1, radix, 0);
        // System.out.println(calcPossibility(1, digitCount, radix, -1) %
        // 1000000007);

        /* for (int[] arr : resultSheet) { for (int i : arr) {
         * System.out.print(i + "\t"); } System.out.println(); } */
        System.out.println(total % 1000000007);
    }

    public static long calcPossibility(int level, int endLevel, int radix, int prevDigit) {
        if (level > endLevel) {
            return 0;
        }
        if (resultSheet[level][prevDigit] < 0) {
            if (level == endLevel) {
                if (prevDigit == 0 || prevDigit == radix - 1) {
                    resultSheet[level][prevDigit] = radix - 1;
                } else {
                    resultSheet[level][prevDigit] = radix - 2;
                }
            } else {
                // int endDigit = prevDigit == 0 || prevDigit == radix - 1 ?
                // radix : radix - 1;
                long sum = 0;
                for (int i = 0; i < radix; i++) {
                    if (i == prevDigit - 1 || i == prevDigit + 1)
                        continue;

                    sum += calcPossibility(level + 1, endLevel, radix, i) % 1000000007;
                }
                resultSheet[level][prevDigit] = sum % 1000000007;
            }

        }
        return resultSheet[level][prevDigit];
    }
}
