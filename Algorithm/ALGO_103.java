import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ALGO_103 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        Integer[] factors = fetchFactor(num);
        int sum = 0;
        for (Integer integer : factors) {
            sum += integer;
        }

        if (num == sum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

    public static Integer[] fetchFactor(int num) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= num / 2; i++) {
            if (num % i == 0) {
                result.add(i);
            }
        }
        return result.toArray(new Integer[0]);
    }
}
