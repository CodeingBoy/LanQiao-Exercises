import java.util.ArrayList;
import java.util.Scanner;

public class BASIC_23 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] isChipOK = new boolean[n];
        for (int i = 0; i < isChipOK.length; i++) {
            isChipOK[i] = true;
        }

        int[][] data = new int[n][n];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = scanner.nextInt();
            }
        }

        for (int i = 0; i < n; i++) { // col
            int goodCount = 0, badCount = 0;
            ArrayList<Integer> goodList = new ArrayList<>(), badList = new ArrayList<>();
            for (int j = 0; j < data.length; j++) { // row
                if (i == j)
                    continue;

                if (data[j][i] == 1) {
                    goodCount++;
                    goodList.add(j);
                } else {
                    badCount++;
                    badList.add(j);
                }
            }

            if (badCount == n - 1) {
                isChipOK[i] = false;
            } else if (goodCount > badCount) {
                for (Integer index : badList) {
                    isChipOK[index] = false;
                }
            } else if (goodCount < badCount) {
                for (Integer index : goodList) {
                    isChipOK[index] = false;
                }
            }
        }

        for (int i = 0; i < isChipOK.length; i++) {
            if (isChipOK[i]) {
                System.out.print((i + 1) + " ");
            }
        }
    }
}
