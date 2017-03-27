import java.util.Scanner;

public class BASIC_24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v1 = scanner.nextInt();
        int v2 = scanner.nextInt();
        int t = scanner.nextInt(), s = scanner.nextInt(), l = scanner.nextInt();

        int sRabbit = 0, sTurtle = 0;
        int rabbitWaitCount = 0;
        int tickCount = 0;
        while (sRabbit < l && sTurtle < l) {
            if (rabbitWaitCount < 1) {
                sRabbit += v1;
            }

            sTurtle += v2;

            if (rabbitWaitCount < 1 && sRabbit - sTurtle >= t) {
                rabbitWaitCount = s + 1;
            }
            
            if (rabbitWaitCount > 0) {
                rabbitWaitCount--;
            }

            tickCount++;
            System.out.println(tickCount + ": " + sRabbit + " " + sTurtle + " dis:" + (sRabbit - sTurtle) + " wait: "
                    + rabbitWaitCount);
        }

        if (sRabbit > sTurtle)
        {
            System.out.println("R");
        } else if (sRabbit < sTurtle) {
            System.out.println("T");
        } else {
            System.out.println("D");
        }
        System.out.println(tickCount);
    }
}
