import java.util.Scanner;

public class ALGO_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();

        int[] sequence = new int[length];
        for (int i = 0; i < sequence.length; i++) {
            sequence[i] = scanner.nextInt();
        }

        int askCount = scanner.nextInt();
        while (askCount > 0) {
            int start = scanner.nextInt() - 1;
            int end = scanner.nextInt(); // scanner.nextInt() - 1 + 1
            int pos = scanner.nextInt();

            int[] tempSeq = new int[length];
            System.arraycopy(sequence, 0, tempSeq, 0, length);
            pos = (end - start) - pos;

            //System.out.println(pos);

            System.out.println(QuickSelect(tempSeq, start, end, pos));

            askCount--;
        }
    }

    private static int QuickSelect(int[] array, int start, int end, int pos) {
        if (start + 1 >= end) {
            return array[start];
        }

        // LomutoPartition
        int pivot = array[start];

        int smallerEndIndex = start;
        int undividedIndex = start + 1;
        while (undividedIndex < end) {
            if (array[undividedIndex] < pivot) {
                smallerEndIndex++;
                int temp = array[smallerEndIndex];
                array[smallerEndIndex] = array[undividedIndex];
                array[undividedIndex] = temp;
            }
            undividedIndex++;
        }

        int temp = array[smallerEndIndex];
        array[smallerEndIndex] = array[start];
        array[start] = temp;

//        for (int i = start; i < end; i++) {
//            System.out.print(array[i] + " ");
//        }
//        System.out.print(" pos: " + pos);
//        System.out.println();

        if (pos == smallerEndIndex - start) {
            return array[smallerEndIndex];
        } else if (pos < smallerEndIndex - start) {
            return QuickSelect(array, start, smallerEndIndex, pos);
        } else {
            return QuickSelect(array, smallerEndIndex + 1, end, start + pos - smallerEndIndex - 1);
        }
    }
}
