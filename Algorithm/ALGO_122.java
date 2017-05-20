import java.util.Scanner;

public class ALGO_122 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int returnCount = scanner.nextInt();
        int borrowCount = scanner.nextInt();
        int[] queue = new int[returnCount + borrowCount];

        System.out.println(select(queue, 0, returnCount + borrowCount, 0, 0, returnCount, borrowCount));
    }

    public static int select(int[] queue, int pos, int end, int curReturn, int curBorrow, int remainReturn,
            int remainBorrow) {
        if (pos == end) {
            int sum = 0;
            for (int i : queue) {
                sum += i;
            }
            assert (sum < 0);

            return 1;
        }

        int count = 0;

        if (remainBorrow > 0 && curBorrow + 1 <= curReturn) {
            queue[pos] = 1;
            count += select(queue, pos + 1, end, curReturn, curBorrow + 1, remainReturn, remainBorrow - 1);
        }
        if (remainReturn > 0) {
            queue[pos] = -1;
            count += select(queue, pos + 1, end, curReturn + 1, curBorrow, remainReturn - 1, remainBorrow);
        }

        return count;
    }
}
