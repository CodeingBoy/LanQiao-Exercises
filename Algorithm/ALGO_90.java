import java.util.Scanner;

public class ALGO_90 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numCount = scanner.nextInt();

        if (numCount >= 1) {
            int maxNum = 0, maxTime = -1;
            int lastNum = Integer.MIN_VALUE, curTime = -1;
            for (int i = 0; i < numCount; i++) {
                int curNum = scanner.nextInt();
                if (curNum != lastNum) {
                    if (maxTime < curTime) {
                        maxTime = curTime;
                        maxNum = lastNum;
                    }

                    lastNum = curNum;
                    curTime = 1;
                } else {
                    curTime++;
                }
            }
            if (maxTime < curTime) {
                maxTime = curTime;
                maxNum = lastNum;
            }

            System.out.println(maxNum);
        }
    }
}
