import java.util.Scanner;

public class ALGO_38 {
    private final static boolean DEBUG = false;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int personCount = scanner.nextInt(), pileCount = scanner.nextInt();
            int[] water = new int[personCount + 1];
            for (int i = 1; i < water.length; i++) {
                water[i] = scanner.nextInt();
            }

            int time = 0;
            int nextPerson = 1;
            int[] plies = new int[pileCount];

            while (true) {
                boolean allOK = true;
                for (int i = 0; i < plies.length; i++) {
                    int personIndex = plies[i];
                    if (personIndex == -1) { // closed
                        continue;
                    }
                    allOK = false;
                    if (water[personIndex] == 0) {
                        if (nextPerson <= personCount) {
                            plies[i] = nextPerson;
                            nextPerson++;
                        } else {
                            plies[i] = -1;
                            continue;
                        }
                    }
                    water[plies[i]]--;
                }

                if (allOK) {
                    time--;
                    break;
                }

                if (DEBUG) {
                    for (int i = 0; i < plies.length; i++) {
                        if (plies[i] != -1)
                            System.out.print(i + "-" + water[plies[i]] + " ");
                    }
                    System.out.println();
                }
                time++;
            }

            System.out.println(time);
        }
    }
}
