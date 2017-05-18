import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ALGO_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int aCount = scanner.nextInt();
        int[] setA = new int[aCount];
        for (int i = 0; i < setA.length; i++) {
            setA[i] = scanner.nextInt();
        }

        int bCount = scanner.nextInt();
        int[] setB = new int[bCount];
        for (int i = 0; i < setB.length; i++) {
            setB[i] = scanner.nextInt();
        }

        // sort
        Arrays.sort(setA);
        Arrays.sort(setB);

        StringBuffer buffer = new StringBuffer();
        for (int i : join(setA, setB)) {
            buffer.append(i + " ");
        }
        System.out.println(buffer.toString().trim());

        buffer = new StringBuffer();
        for (int i : and(setA, setB)) {
            buffer.append(i + " ");
        }
        System.out.println(buffer.toString().trim());

        buffer = new StringBuffer();
        for (int i : minus(setA, setB)) {
            buffer.append(i + " ");
        }
        System.out.println(buffer.toString().trim());
    }

    private static Integer[] join(int[] setA, int[] setB) {
        ArrayList<Integer> result = new ArrayList<>();

        int curPosA = 0, curPosB = 0;

        while (curPosA < setA.length && curPosB < setB.length) {
            int curElementA = setA[curPosA];
            int curElementB = setB[curPosB];

            if (curElementA == curElementB) {
                result.add(curElementA);
            }

            if (curElementA < curElementB) {
                curPosA++;
            } else {
                curPosB++;
            }
        }

        return result.toArray(new Integer[0]);
    }

    private static Integer[] and(int[] setA, int[] setB) {
        Set<Integer> result = new TreeSet<Integer>();

        for (int i : setA) {
            result.add(i);
        }
        for (int i : setB) {
            result.add(i);
        }

        return result.toArray(new Integer[0]);
    }

    private static Integer[] minus(int[] setA, int[] setB) {
        ArrayList<Integer> result = new ArrayList<>();

        Integer[] joinSet = join(setA, setB);
        int joinPos = 0;

        if (joinSet == null || joinSet.length == 0) {
            for (int i : setA) {
                result.add(i);
            }
        } else {
            for (int i : setA) {
                if (joinPos < joinSet.length - 1 && i > joinSet[joinPos]) {
                    joinPos++;
                }
                if (i != joinSet[joinPos]) {
                    result.add(i);
                }
            }
        }

        return result.toArray(new Integer[0]);
    }
}
